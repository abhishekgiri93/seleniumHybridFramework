package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.AddOrRemoveElementsPage;
import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.MainHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddOrRemoveElementsPageTestCases extends Base {

    WebDriver driver;
    AddOrRemoveElementsPage addOrRemoveElementsPage;


    public AddOrRemoveElementsPageTestCases(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("chrome"));
        MainHomePage mainHomePage = new MainHomePage(driver,utilities);
        addOrRemoveElementsPage = mainHomePage.navigateToAddOrRemoveElementsPage();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(description = 'Verify add & remove button feature', priority = 1)
    public void verifyAddElementButton(){
        addOrRemoveElementsPage.clickAddElementButton();
        Assert.assertTrue(addOrRemoveElementsPage.dele);
    }


}
