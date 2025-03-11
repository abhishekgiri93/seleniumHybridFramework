package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.LoginPage;
import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Register extends Base{
    public WebDriver driver;
    public LoginPage loginPage;
    public RegisterPage registerPage;


    public Register(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 1, alwaysRun = true)
    public void verifySendOtpToRegister() throws InterruptedException, AWTException {
        robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_F12);
        Thread.sleep(1000);

        loginPage.enterNumberInNumberInputField(testData.getProperty("validNotRegisteredNumber"));
        loginPage.clickRequestOtpButtonOnNumberPage();
        loginPage.enterOtpInOtpInputField(testData.getProperty("validOtp"));
        Thread.sleep(20000);
        loginPage.clickCheckBox();
        loginPage.clickLoginButtonOnOtpPage();
        Assert.assertTrue(registerPage.welcomeTextPresence(), "cannot redirected to Registration Page when New valid but UnRegistered Number is entered with Valid Otp");
    }

    @Test(priority = 2, alwaysRun = true)
    public void verifyRegisterPageRegisterNewNumber() throws InterruptedException, AWTException {
        verifySendOtpToRegister();
    }


}
