package com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[normalize-space()='Welcome to New User Saleit Admin']")
    WebElement welcomeText;

    @FindBy(xpath = "//input[@id='mat-input-2']")
    WebElement companyName;

    @FindBy(xpath = "//input[@id='mat-input-3']")
    WebElement ownerName;

    @FindBy(xpath = "//input[@id='mat-input-4']")
    WebElement email_Id;

    @FindBy(xpath = "//input[@id='mat-input-5']")
    WebElement alternateNumber;

    @FindBy(xpath = "//input[@id='mat-input-6']")
    WebElement gstinNumber;

    @FindBy(xpath = "//input[@id='mat-input-7']")
    WebElement address;

    @FindBy(xpath =
            "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c109-11 ng-star-inserted']")
    WebElement companyType;

    @FindBy(xpath = "//span[@class='mat-button-wrapper']")
    WebElement registerButton;


    public boolean welcomeTextPresence(){
        try {
            return welcomeText.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }




}
