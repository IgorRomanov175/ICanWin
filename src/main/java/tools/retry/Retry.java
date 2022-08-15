package tools.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int actualRetry = 0;
    private final static int MAX_RETRY = 4;

    @Override
    public boolean retry(ITestResult result) {
        if(actualRetry < MAX_RETRY){
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}