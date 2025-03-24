package com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages;

import com.seleniumHybridFrameworkProject.qa.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckboxesPage {
    WebDriver driver;
    Utilities utilities;

    public CheckboxesPage(WebDriver driver, Utilities utilities){
        this.driver = driver;
        this.utilities = utilities;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    private WebElement checkbox1;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    private WebElement checkbox2;

    public WebElement getCheckbox1(){
        return checkbox1;
    }

    public WebElement getCheckbox2() {
        return checkbox2;
    }

    public void clickCheckbox1(){
        utilities.getWait(driver).until(ExpectedConditions.elementToBeClickable(checkbox1));
        checkbox1.click();
    }

    public void clickCheckbox2(){
        utilities.getWait(driver).until(ExpectedConditions.elementToBeClickable(checkbox2));
        checkbox2.click();
    }




}
