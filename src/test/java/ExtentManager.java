import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createreport(String file){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);
        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);
        return extent;


    }
}
