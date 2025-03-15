package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.AddOrRemoveElementsPage;
import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.MainHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddOrRemoveElementsPageTestCase extends Base {

    WebDriver driver;
    AddOrRemoveElementsPage addOrRemoveElementsPage;


    public AddOrRemoveElementsPageTestCase(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        MainHomePage mainHomePage = new MainHomePage(driver,utilities);
        addOrRemoveElementsPage = mainHomePage.navigateToAddOrRemoveElementsPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(description = "Verify add button working", priority = 1)
    public void verifyAddButton(){
        int beforeCount = addOrRemoveElementsPage.countOfAddedButtons();
        addOrRemoveElementsPage.clickAddElementButton();
        int afterCount = addOrRemoveElementsPage.countOfAddedButtons();
        Assert.assertEquals(beforeCount+1, afterCount, "New button was not added!");
    }

    @Test(description = "Verify delete button working", priority = 2)
    public void verifyDeleteButton(){
        int beforeAddCount = addOrRemoveElementsPage.countOfAddedButtons();
        addOrRemoveElementsPage.clickAddElementButton();
        int afterAddCount = addOrRemoveElementsPage.countOfAddedButtons();
        Assert.assertEquals(beforeAddCount+1, afterAddCount, "New button was not added for deletion!");

        int beforeDeleteCount = addOrRemoveElementsPage.countOfAddedButtons();
        addOrRemoveElementsPage.clickDeleteButtons();
        int afterDeleteCount = addOrRemoveElementsPage.countOfAddedButtons();
        Assert.assertEquals(beforeDeleteCount-1, afterDeleteCount, "Button was not Deleted" );
    }



}
