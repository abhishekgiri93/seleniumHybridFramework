//package com.seleniumHybridFrameworkProject.qa.testcases;
//
//
//import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.LoginPage;
//import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.WebsiteHeader;
//import com.seleniumHybridFrameworkProject.qa.utils.Utilities;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//
//public class Login extends Base {
//    WebDriver driver;
//    LoginPage loginPage;
//    WebsiteHeader websiteHeader;
//
//    public Login() {
//        super();
//    }
//
//
//    @BeforeMethod
//    public void setUp() {
//        // loadPropertiesFile();
//        // One method is this for calling the loadPropertiesFile from Base class method and
//        // 2nd method is make this method in Base class as constructor by changing its name
//        // to class name and then make a constructor of Login class and then insert Super()
//        // method in Login class constructor which denotes that this Login class constructor
//        // calls its Super(Parent) class constructor i.e Base class constructor
//        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
//        loginPage = new LoginPage(driver);
//        websiteHeader = new WebsiteHeader(driver);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//
////    @DataProvider(name = "validDataProvider")
////    public Object[][] supplyTestData() {
////        // Declare and assign value to two dimensional array
////        // but the data in this method is hardcoded which we do not want
////        // so we will create next data provider and take data from excel file in that and no hardcoding
////        Object [][] data = {{"6356697608","123456"},{"8840702364","234567"},{"6356697601","345678"}};
////        return data;
////    }
////
////    @Test(priority ,dataProvider = "validDataProvider")
////    // this test will run for 3 times because it has 3 set of data in excel dile and for all 3 set it will run individually
////    // this test will  run acc to upper data provider hardcoded way
////    public void verifyLoginWithValidCredentialsInDataProvider(String Phone_Number,String  Otp) throws InterruptedException, AWTException {
////        Robot robot = new Robot();
////        robot.keyPress(KeyEvent.VK_F12);
////        robot.keyRelease(KeyEvent.VK_F12);
////        Thread.sleep(2000);
////        LoginPage loginPage = new LoginPage(driver);
////        WebsiteHeader websiteHeader = new WebsiteHeader(driver);
////
////        loginPage.enterNumberInNumberInputField(Phone_Number);
////        loginPage.clickRequestOtpButtonOnNumberPage();
//////        Scanner sc1 = new Scanner(System.in);  // Create a Scanner object
//////        System.out.println("Enter OTP");
//////        int OTP = sc1.nextInt();
//////        System.out.println("You Entered : " + OTP);
//////        Thread.sleep(3000);
//////        driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.valueOf(OTP));
////        loginPage.enterOtpInOtpInputField(Otp);
////        Thread.sleep(25000);
////        loginPage.clickCheckBox();
////        loginPage.clickLoginButtonOnOtpPage();
////        Assert.assertTrue(websiteHeader.verifyWebsiteHeaderLogoTextPresence(), "Didn't Logged in with valid credentials also");
////
////    }
//
//
//    @DataProvider(name = "validDataProvider1")
//    public Object[][] supplyTestData1() {
//        // Declare and assign value to two dimensional array
//        // here we take data from excel file in that and no hardcoding
//        Object[][] data2 = Utilities.getTestDataFromExcel("Login");
//        return data2;
//    }
//
//    @Test(priority = 2, dataProvider = "validDataProvider1")
//    // this test will run for 3 times because it has 3 set of data in excel dile and for all 3 set it will run individually
//    public void verifyLoginWithValidCredentialsInExcelDataProviderFile(String Phone_Number, String Otp) throws InterruptedException, AWTException {
//        //Robot robot = new Robot(); not needed as already initialized in setUp method before every testNG method
//        for (int i = 0; i < 2; i++) {
//            robot.keyPress(KeyEvent.VK_F12);
//            robot.keyRelease(KeyEvent.VK_F12);
//        }
//        Thread.sleep(2000);
//
//        loginPage.enterNumberInNumberInputField(Phone_Number);
//        loginPage.clickRequestOtpButtonOnNumberPage();
////        Scanner sc1 = new Scanner(System.in);  // Create a Scanner object
////        System.out.println("Enter OTP");
////        int OTP = sc1.nextInt();
////        System.out.println("You Entered : " + OTP);
////        Thread.sleep(3000);
////        driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(Integer.toString((int) OTP));
//        loginPage.enterOtpInOtpInputField(Otp);
//        Thread.sleep(20000);
//        loginPage.clickCheckBox();
//        loginPage.clickLoginButtonOnOtpPage();
//        Thread.sleep(2000);
//        Assert.assertTrue(websiteHeader.verifyWebsiteHeaderLogoTextPresence(), "Didn't Logged in with valid credentials also");
//
//
//    }
//
//    @Test(priority = 3)
//    public void verifyLoginWithInvalidCredentials() throws InterruptedException, AWTException {
//
//        robot.keyPress(KeyEvent.VK_F12);
//        robot.keyRelease(KeyEvent.VK_F12);
//        Thread.sleep(500);
//
//        loginPage.enterNumberInNumberInputField(testData.getProperty("invalidNotRegisteredNumber"));
//        loginPage.clickRequestOtpButtonOnNumberPage();
////        Scanner sc1 = new Scanner(System.in);  // Create a Scanner object
////        System.out.println("Enter OTP");
////        int OTP = sc1.nextInt();
////        System.out.println("You Entered : " + OTP);
////        Thread.sleep(3000);
////        driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(Integer.toString((int) OTP));
//        loginPage.enterOtpInOtpInputField(testData.getProperty("invalidOtp"));
//        loginPage.clickCheckBox();
//        Thread.sleep(20000);
//        loginPage.clickLoginButtonOnOtpPage();
//        Thread.sleep(4000);
//        Assert.assertTrue(loginPage.LoginPageLoginAndRegisterLogoPresent(), "Logged in with Invalid Credentials also");
//
//    }
//
//    @Test(priority = 4)
//    public void verifyRequestOtpWithoutMobileNumber() throws InterruptedException {
//        loginPage.clickRequestOtpButtonOnNumberPage();
//        Thread.sleep(1000);
//        Assert.assertTrue(loginPage.RequestOtpButtonPresent(), " On clicking Request Otp, User redirected to Login page without entering mobile number");
//    }
//
//    @Test(priority = 5)
//    public void verifyLoginWithoutOtp() throws InterruptedException {
//        Thread.sleep(500);
//        loginPage.enterNumberInNumberInputField(prop.getProperty("validRegisteredNumber"));
//        loginPage.clickRequestOtpButtonOnNumberPage();
//        loginPage.clickCheckBox();
//        loginPage.clickLoginButtonOnOtpPage();
//        Thread.sleep(1000);
//        Assert.assertTrue(loginPage.LoginPageLoginAndRegisterLogoPresent(), "Logged in without Otp");
//
//    }
//
//    @Test(priority = 6)
//    public void verifyLoginWithValidNumberInvalidOtp() throws InterruptedException {
//        Thread.sleep(500);
//        loginPage.enterNumberInNumberInputField(prop.getProperty("validRegisteredNumber"));
//        loginPage.clickRequestOtpButtonOnNumberPage();
//        loginPage.enterOtpInOtpInputField(testData.getProperty("invalidOtp"));
//        loginPage.clickCheckBox();
//        loginPage.clickLoginButtonOnOtpPage();
//        Thread.sleep(1000);
//        Assert.assertTrue(loginPage.LoginPageLoginAndRegisterLogoPresent(), "Logged in with valid number and invalid Otp");
//    }
//
//    @Test(priority = 7)
//    public void verifyResendOtpLinkDisabledTillSingleMinute() throws InterruptedException, AWTException {
//        Thread.sleep(500);
//        loginPage.enterNumberInNumberInputField(prop.getProperty("validRegisteredNumber"));
//        loginPage.clickRequestOtpButtonOnNumberPage();
//        Assert.assertFalse(loginPage.resendOtpLinkEnabled(), "Resend Otp link is enabled before 1 minute");
//        Thread.sleep(20000);
//        Assert.assertFalse(loginPage.resendOtpLinkEnabled(), "Resend Otp link is enabled after 20 Seconds");
//        Thread.sleep(20000);
//        Assert.assertFalse(loginPage.resendOtpLinkEnabled(), "Resend Otp link is enabled after 40 Seconds");
//        Thread.sleep(18000);
//        Assert.assertFalse(loginPage.resendOtpLinkEnabled(), "Resend Otp link is enabled on 59th Seconds");
//
//    }
//
//    @Test(priority = 8)
//    public void verifyResendOtpLinkEnabledAfterAMinute() throws InterruptedException, AWTException {
//        Thread.sleep(500);
//        loginPage.enterNumberInNumberInputField(prop.getProperty("validRegisteredNumber"));
//        loginPage.clickRequestOtpButtonOnNumberPage();
//        Thread.sleep(61000);
//        Assert.assertTrue(loginPage.resendOtpLinkEnabled(), "Resend Otp link is not enabled after 1 minute");
//    }
//
//    @Test(priority = 9)
//    public void verifyLoginWithOtpSentBeforeResendOtp() throws InterruptedException, AWTException {
//
//        robot.keyPress(KeyEvent.VK_F12);
//        robot.keyRelease(KeyEvent.VK_F12);
//        Thread.sleep(500);
//
//
//        loginPage.enterNumberInNumberInputField(testData.getProperty("validNotRegisteredNumber"));
//        loginPage.clickRequestOtpButtonOnNumberPage();
//        Thread.sleep(1000);
//        loginPage.enterOtpInOtpInputField(testData.getProperty("validOtp"));
//        loginPage.clickCheckBox();
//        Thread.sleep(61000);
//        loginPage.clickResendOtpLink();
//        loginPage.enterOtpInOtpInputField(testData.getProperty("validOldOtp"));
//        Thread.sleep(20000);
//        loginPage.clickLoginButtonOnOtpPage();
//        Thread.sleep(1000);
//        Assert.assertTrue(loginPage.LoginPageLoginAndRegisterLogoPresent(), "Logged in with Old Otp after clicking Resend Otp link");
//
//    }
//
//
//}