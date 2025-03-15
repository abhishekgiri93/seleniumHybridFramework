package com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages;

import com.seleniumHybridFrameworkProject.qa.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddOrRemoveElementsPage {

    WebDriver driver;
    Utilities utilities;

    public AddOrRemoveElementsPage(WebDriver driver, Utilities utilities) {
        this.driver = driver;
        this.utilities = utilities;
        PageFactory.initElements(driver, this);
    }

    //-------------------------------------------------------------------------------------------------------------

    //WebElements Locators Now

    @FindBy(xpath = "//button[text() = 'Add Element']")
    private WebElement addElementButton;

    @FindBy(xpath = "//*[@class = 'added-manually']")
    private WebElement deleteButtons;

    @FindBy(xpath = "//*[@class = 'added-manually']")
    private List<WebElement> allDeleteButtons;


    //-----------------------------------------------------------------------------------------------------------

    // Access Methods for WebElements

    public void clickAddElementButton() {
        addElementButton.click();
    }

    public void clickDeleteButtons() {
        deleteButtons.click();
    }

    public int countOfAddedButtons(){
        return allDeleteButtons.size();
    }


}
