package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.MainHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainHomePageTestCases extends Base {
    WebDriver driver;
    MainHomePage mainHomePage;

    public MainHomePageTestCases() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        mainHomePage = new MainHomePage(driver, utilities);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(description = "check the website title", priority = 1)
    public void verifyPageTitle() {
        mainHomePage.setExpectedTitle(utilities.getProperty("expectedTitle"));
        Assert.assertEquals(mainHomePage.getActualTitle(), mainHomePage.getExpectedTitle(), "Title is not as Expected Title");
    }

//    @Test(description = "should run with Url1 in Config",priority = 2)
//    public void verifySuccessfulLoginWithValidCredentials() {
//        mainHomePage.clickBasicAuthButtonOnMainPage();
//        Assert.assertEquals(mainHomePage.getTextInsideBasicAuth(), utilities.getProperty("expectedSuccessLoginMsg"));
//    }

    @Test
    public void verifyBrokenImages() {
        mainHomePage.clickBrokenImagesButton();
        utilities.processImages(mainHomePage.getAllImagesOnPage());
    }


}
