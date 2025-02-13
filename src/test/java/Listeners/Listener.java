package Listeners;

import Utilities.LogsUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements IInvokedMethodListener, ITestListener {
    public void onTestStart(ITestResult result) {
        LogsUtils.info("Testcase " + result.getName() + " started");
    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Testcase " + result.getName() + " passed");
    }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Testcase " + result.getName() + " skipped");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("Testcase " + testResult.getName() + " failed");
        }
    }
}
