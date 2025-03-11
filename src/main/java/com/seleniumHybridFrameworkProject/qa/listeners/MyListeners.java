package com.seleniumHybridFrameworkProject.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniumHybridFrameworkProject.qa.utils.ExtentReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {
        // System.out.println("Execution of test script started");
        // This method is for start of execution of test script not a single test or a bunch of tests
        extentReport = ExtentReporter.generateExtentReport();
    }
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO, testName+" started executing" );
//        System.out.println(testName+" started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.PASS,testName+" got successfully executed");
//        System.out.println(testName+" got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        // System.out.println("Screenshot Taken");
        // video url "Learn Selenium Java Hybrid Framework in 12 hours (TestNG, POM, PF, ExtentReports,Git,GitHub,Jenkins)" at streaming time 7:50
        // Type-Casting WebDriver
        WebDriver driver = null;
        // to pass the driver here we have to make driver of Login class
        // public otherwise here driver cannot come and show null pointer exception
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException |IllegalArgumentException| NoSuchFieldException e) {
            e.printStackTrace();
        }
        File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
        // Screenshot taken and saved in destinationScreenshotPath and copied in Screenshot folder with name test'sName.png
        try {
            FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // below line will copy screenshot from destinationScreenshotPath and
        // add screenshot to extent Reports
        extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, testName+" got failed");
//        System.out.println(testName+" got failed");
//        System.out.println(result.getThrowable());
        // Due to line 2 log method lines upper two sout lines get commented out
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.SKIP, testName+" got skipped");
//        System.out.println(testName+" got skipped");
//        System.out.println(result.getThrowable());
    }


    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
//        System.out.println("Finished executing Project Tests");
    }   // This method is for finishing the whole script of tests not a single test or a bunch of tests
}
