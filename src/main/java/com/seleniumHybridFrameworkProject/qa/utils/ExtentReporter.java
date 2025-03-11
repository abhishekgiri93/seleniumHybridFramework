package com.seleniumHybridFrameworkProject.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExtentReporter {
    public static ExtentReports generateExtentReport(){
        ExtentReports extentReport = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("seleniumHybridFramework Test Automation Results Reports");
        sparkReporter.config().setDocumentTitle("SHF Automation Report");
        sparkReporter.config().setTimeStampFormat("DD/MM/YYYY hh:mm:sss");

        extentReport.attachReporter(sparkReporter);

        Properties configProp = new Properties();
        File configPropFile = new File(System.getProperty("user.dir")+"//src/main/java/com/seleniumHybridFrameworkProject/qa/config/config.properties");
        try {
            FileInputStream configPropFileInputStream = new FileInputStream(configPropFile);
            configProp.load(configPropFileInputStream);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // create a package then a class then main java method then
        // in main java method System.getProperties().list(System.out);

        extentReport.setSystemInfo("Operating System", System.getProperty("os.name") );
        extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));
        extentReport.setSystemInfo("Application Url", configProp.getProperty("Url"));
        extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
        extentReport.setSystemInfo("Registered Number", configProp.getProperty("validRegisteredNumber"));
        extentReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
        extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));

        return extentReport;

    }
}
