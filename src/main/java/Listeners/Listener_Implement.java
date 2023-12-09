package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Implement implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+"= Test Start");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+"= Test Pass");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName()+"= Test is Fail");
    }
}
