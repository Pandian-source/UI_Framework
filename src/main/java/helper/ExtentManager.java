package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Data.ConfigFileReader;

public class ExtentManager {

    static ExtentReports extent;
    static ConfigFileReader configReader;

    public static ExtentReports getReportObject() {
        configReader = new ConfigFileReader();
        String path = configReader.getBaseDir() + "/Reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("ClarityTTS Test Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Pandian Angaiah");
        return extent;

    }
}



