package framework;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.printf("======================================== STARTING TEST %s ========================================\n",
                result.getName());
        System.out.printf("\t\"%s\"\n",result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.printf("======================================== FINISHED TEST %s (Duration: %ss)========================================\n",
                result.getName(),getExecutionTime(result));
    }

    public void onTestFailure(ITestResult result) {
        System.out.printf("======================================== FAILED TEST %s (Duration: %ss)========================================\n",
                result.getName(),getExecutionTime(result));
    }

    public void onTestSkipped(ITestResult result) {
        System.out.printf("======================================== SKIPPING TEST %s ========================================\n",
                result.getMethod().getTestClass().getTestName());
    }

    private long getExecutionTime(ITestResult iTestResult){
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
