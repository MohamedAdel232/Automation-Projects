package Listeners;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Factories.DriverFactory.getDriver;

public class Listener implements ITestListener, IInvokedMethodListener {
    public void onTestStart(ITestResult result) {
        LogsUtils.info("Testcase: " + result.getName() + " started");
    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Testcase: " + result.getName() + " passed");
    }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Testcase: " + result.getName() + " skipped");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("Testcase: " + testResult.getName() + " failed");
            try {
                Utility.takeScreenshot(getDriver(), testResult.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
