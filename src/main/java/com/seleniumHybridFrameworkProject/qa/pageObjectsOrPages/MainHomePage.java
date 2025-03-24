package com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages;

import com.seleniumHybridFrameworkProject.qa.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainHomePage {

    WebDriver driver;
    private String expectedTitle;
    Utilities utilities;

    public MainHomePage(WebDriver driver, Utilities utilities) {
        this.driver = driver;
        this.utilities = utilities;
        PageFactory.initElements(driver, this);
    }

    // Find Objects Section -------------------------------------------------------------------------------------
    @FindBy(xpath = "//a[normalize-space()='Basic Auth']")
    private WebElement basicAuthButtonOnMainPage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/p")
    private WebElement textInsideBasicAuth;

    @FindBy(xpath = "//a[text()='Broken Images']")
    private WebElement brokenImagesButton;

    @FindBy(tagName = "img")
    private List<WebElement> allImagesOnPage;

    @FindBy(xpath = "//a[text() = 'Add/Remove Elements']")
    private WebElement addOrRemoveElementsPageButton;

    @FindBy(xpath = "//a[@href = \"/checkboxes\" and text() = \"Checkboxes\"]")
    private WebElement checkboxesLink;



    // Methods Section ------------------------------------------------------------------------------------------
    public String getActualTitle() {
        String actualTitle = driver.getTitle();
        return actualTitle;
    }

    public void setExpectedTitle(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public void clickBasicAuthButtonOnMainPage() {
        basicAuthButtonOnMainPage.click();
    }

    public String getTextInsideBasicAuth() {
        return textInsideBasicAuth.getText();
    }

    public void clickBrokenImagesButton() {
        utilities.getWait(driver).until(ExpectedConditions.elementToBeClickable(brokenImagesButton));
        brokenImagesButton.click();
    }

    public List<WebElement> getAllImagesOnPage() {
        utilities.getWait(driver).until(ExpectedConditions.visibilityOfAllElements(allImagesOnPage));
        return allImagesOnPage;
    }

    public AddOrRemoveElementsPage navigateToAddOrRemoveElementsPage(){
        addOrRemoveElementsPageButton.click();
        return new AddOrRemoveElementsPage(driver, utilities);
    }

    public CheckboxesPage navigateToCheckboxesPage(){
        checkboxesLink.click();
        return new CheckboxesPage(driver, utilities);
    }


}
