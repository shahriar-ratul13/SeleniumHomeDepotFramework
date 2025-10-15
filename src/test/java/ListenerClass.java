import common.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerClass implements ITestListener {

    // final because after report is generated, we don't want it to change
    private static final ExtentReports extent = ExtentManager.createInstance("report.html");
    private static ThreadLocal<ExtentTest> methodTest = new ThreadLocal<>();

    private ExtentTest getTest(ITestResult result){
        return methodTest.get();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        // Getting name of method, so we can track what failed
        String methodName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(methodName);
        methodTest.set(test);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH-mm-ss");
        Date date = new Date();

        // use date in name so its dynamic
        String name = dateFormat.format(date);

        // Take screenshot and store in file under given directory
        File file = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("src/screenshot/" + name + ".png"  ));
        } catch (IOException e){

        }

        getTest(result).fail(result.getThrowable());

    }

//    @Override
//    public void onTestSuccess(ITestResult result) {
//
//        System.out.println("Test succeed");
//    }

    public synchronized void onTestFinish() {
        extent.flush();
    }
}
