package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.CheckboxesPage;
import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.MainHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesPageTC extends Base{
    WebDriver driver ;
    MainHomePage mainHomePage ;
    CheckboxesPage checkboxesPage;

    public CheckboxesPageTC(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        mainHomePage = new MainHomePage(driver, utilities);
        checkboxesPage = mainHomePage.navigateToCheckboxesPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Verify checkbox 1")
    public void verifyCheckbox1() throws InterruptedException {
        if(checkboxesPage.getCheckbox1().isSelected()){
            Thread.sleep(2000); // Pauses execution for 2 seconds
            checkboxesPage.clickCheckbox1();
            Thread.sleep(2000);
            Assert.assertFalse(checkboxesPage.getCheckbox1().isSelected(), "CheckBox1 should not be checked if checked already");
        } else {
            Thread.sleep(2000); // Pauses execution for 2 seconds
            checkboxesPage.clickCheckbox1();
            Thread.sleep(2000); // Pauses execution for 2 seconds
            Assert.assertTrue(checkboxesPage.getCheckbox1().isSelected(), "CheckBox1 should be checked");
        }
    }

    @Test(description = "Verify checkbox 2")
    public void verifyCheckbox2() throws InterruptedException {
        if(checkboxesPage.getCheckbox2().isSelected()){
            Thread.sleep(2000); // Pauses execution for 2 seconds
            checkboxesPage.clickCheckbox2();
            Thread.sleep(2000); // Pauses execution for 2 seconds
            Assert.assertFalse(checkboxesPage.getCheckbox2().isSelected(), "CheckBox2 should not be checked if checked already");
        } else {
            checkboxesPage.clickCheckbox2();
            Thread.sleep(2000); // Pauses execution for 2 seconds
            Assert.assertTrue(checkboxesPage.getCheckbox2().isSelected(), "checkbox2 should be checked");
        }

    }


}
