package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.pageObjectsOrPages.MainHomePage;
import org.openqa.selenium.WebDriver;

public class CheckboxesPageTC extends Base{
    WebDriver driver ;
    MainHomePage mainHomePage ;

    public CheckboxesPageTC(){
        super();
    }

    public void setUp(){
        driver = initializeBrowserAndOpenApplicationUrl("browserName");
        mainHomePage = new MainHomePage(driver, utilities);
        mainHomePage.navigateToCheckboxesPage();
    }


}
