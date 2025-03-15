//package com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages;
//
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class WebsiteHeader {
//    WebDriver driver;
//
//    @FindBy(xpath = "//span[@class='logo-text']")
//    private WebElement websiteHeaderLogoText;
//
//    public WebsiteHeader(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    // This below method is used t0 verify if the element is present on the page
//    // to verify that the Login is successful or not, if element is present than
//    // login is successful and if not present than login is not successful
//    public boolean verifyWebsiteHeaderLogoTextPresence(){
//        try {
//            return websiteHeaderLogoText.isDisplayed(); // Element displayed , return true, Element not displayed, return false
//        } catch(NoSuchElementException e){
//            return false;       // If caught NoSuchElementException, return false
//        }
//    }
//
//
//}
