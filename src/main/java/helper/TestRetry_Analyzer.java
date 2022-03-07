package helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry_Analyzer implements IRetryAnalyzer {

    int counter = 1;
    int retryLimit = 1;

    @Override
    public boolean retry(ITestResult result)
    {
        if(!result.isSuccess())

        if (counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
