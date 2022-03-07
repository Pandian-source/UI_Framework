package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends ScreenCapture implements ITestListener {

    public SendMailSSLWithAttachment send = new SendMailSSLWithAttachment();

    static final Logger logger = LogManager.getLogger(TestListeners.class);
    ExtentReports extentReports = ExtentManager.getReportObject();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTestThread.set(extentTest);
        logger.info("New Test Started " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver clientDriver = null;
        String argumentName = result.getMethod().getMethodName();
        //String testMethodName = result.getMethod().getMethodName();
        logger.info("Test Successfully Finished " + result.getName());

        try {
            clientDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("clientDriver")
                    .get(result.getInstance());
           // argumentName = (String) result.getTestClass().getRealClass().getDeclaredField("argumentName")
                   // .get(result.getInstance());
           // argumentName = argumentName.replaceAll("[^a-zA-Z0-9]", "_");
        } catch (Exception e1) {

            e1.printStackTrace();
        }
        try {

            String imgFileName = takeScreenSnapShot(clientDriver, argumentName);
            extentTestThread.get().log(Status.PASS, "Test Case Method <b style=\"color:Tomato\"> "
                    + argumentName + " </b> executed successfully but not working as expected");

            logger.info("Image File Name " + argumentName);
            extentTestThread.get().addScreenCaptureFromPath(imgFileName, argumentName);

        } catch (Exception e) {
            logger.warn("Error message user " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver clientDriver = null;
        String argumentName = null;
        String testMethodName = result.getMethod().getMethodName();
        logger.info("Test Successfully Failure Listener Invoked " + result.getName());

        try {
            clientDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("clientDriver")
                    .get(result.getInstance());
           // argumentName = (String) result.getTestClass().getRealClass().getDeclaredField("argumentName")
                    //.get(result.getInstance());
          //  argumentName = argumentName.replaceAll("[^a-zA-Z0-9]", "_");
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {

            e1.printStackTrace();
        }
        try {
            String imgFileName = takeScreenSnapShot(clientDriver, argumentName);
            extentTestThread.get().log(Status.FAIL, "Test Case Method <b style=\"color:Tomato\"> "
                    + argumentName + " </b> executed successfully but not working as expected");

            logger.info("Image File Name " + imgFileName);
            extentTestThread.get().addScreenCaptureFromPath(imgFileName, testMethodName);
        } catch (Exception e) {
            logger.warn("Error message user " + e.getMessage());
        }
        logger.info("Test Failed " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver clientDriver = null;
        String argumentName = null;
        String testMethodName = result.getMethod().getMethodName();
        logger.info("Test Successfully Failure Listener Invoked " + result.getName());

        try {
            clientDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("clientDriver")
                    .get(result.getInstance());
            argumentName = (String) result.getTestClass().getRealClass().getDeclaredField("argumentName")
                    .get(result.getInstance());
            argumentName = argumentName.replaceAll("[^a-zA-Z0-9]", "_");
        } catch (IllegalArgumentException | IllegalAccessException | SecurityException | NoSuchFieldException e1) {
            e1.printStackTrace();
        }
        try {
            String imgFileName = takeScreenSnapShot(clientDriver, argumentName);
            extentTestThread.get().log(Status.SKIP, "Test Case Method <b style=\"color:Tomato\"> "
                    + argumentName + " </b> executed successfully but not working as expected");

            logger.info("Image File Name " + imgFileName);
            extentTestThread.get().addScreenCaptureFromPath(imgFileName, testMethodName);
        } catch (Exception e) {
            logger.warn("Error message user " + e.getMessage());
        }

        logger.info("Test Skipped" + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        logger.info("Test Failed but within success percentage" + result.getName());

    }

    @Override
    public void onStart(ITestContext context) {

        logger.info("This is onStart method" + context.getOutputDirectory());

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

        logger.info("This is onFinish method" + context.getPassedTests());
        logger.info("This is onFinish method" + context.getFailedTests());

       // send.emailSend();
    }
}

