//package com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages;
//
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LoginPage {
//
//    WebDriver driver;
//
//
//    //-------------------------------------------------------------------------------------------------------------
//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//
//
//    // These WebElements are called as "Objects" ------------------------------------------------------------------
//
//    @FindBy(xpath = "//input[@id='mat-input-0']")
//    private WebElement numberInputField;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    private WebElement requestOtpButtonOnNumberPage;
//
//    @FindBy(xpath = "//input[@id='mat-input-1']")
//    private WebElement otpInputField;
//
//    @FindBy(xpath = "//input[@type='checkbox']")
//    private WebElement checkbox;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    private WebElement LoginButtonOnOtpPage;
//
//    @FindBy(xpath = "//h1[normalize-space()='Login/Register']")
//    private WebElement loginAndRegisterLogoOnLoginPage;
//
//    @FindBy(xpath = "//button[@class='resendOtp']")
//    private WebElement resendOtpLink;
//
//
//
//    // Now make Actions ------------------------------------------------------------------------------------------
//
//    public void enterNumberInNumberInputField(String Phone_Number){
//        numberInputField.sendKeys(Phone_Number);
//    }
//
//    public void clickRequestOtpButtonOnNumberPage(){
//        requestOtpButtonOnNumberPage.click();
//    }
//
//    public void enterOtpInOtpInputField(String Otp){
//        otpInputField.sendKeys(Otp);
//    }
//
//    public void clickCheckBox(){
//        checkbox.click();
//    }
//
//    public void clickLoginButtonOnOtpPage(){
//        LoginButtonOnOtpPage.click();
//    }
//
//    public boolean LoginPageLoginAndRegisterLogoPresent(){
//        try {
//            return loginAndRegisterLogoOnLoginPage.isDisplayed(); // Element displayed , return true, Element not displayed, return false
//        } catch (NoSuchElementException e){
//            return false;                       // If caught NoSuchElementException, return false
//        }
//
//    }
//
//    public boolean RequestOtpButtonPresent(){
//        try {
//            return requestOtpButtonOnNumberPage.isDisplayed();
//        } catch (NoSuchElementException e){
//            return false;
//        }
//    }
//
//    public void clickResendOtpLink(){
//        resendOtpLink.click();
//    }
//
//    public boolean resendOtpLinkEnabled(){
//        return resendOtpLink.isEnabled();
//    }
//
//
//
//}
