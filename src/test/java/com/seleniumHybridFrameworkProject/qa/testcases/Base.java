package com.seleniumHybridFrameworkProject.qa.testcases;

import com.seleniumHybridFrameworkProject.qa.utils.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {

    WebDriver driver;
    public Properties prop;      // public so that it can be accessed inside the child class and other classes
    public Properties testData;
    public Actions actions;
    public Utilities utilities;
    public WebDriverWait wait;
    public Robot robot;
    public Select select;
    public JavascriptExecutor jsExecutor;


    // It's a constructor below
    public Base() {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\seleniumHybridFrameworkProject\\qa\\config\\config.properties");
        try {
            FileInputStream Fis = new FileInputStream(propFile);
            prop.load(Fis);
        } catch (Exception e) {  // Inplace of Exception can use Throwable also
            e.printStackTrace();
        }

        testData = new Properties();
        File testdataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\seleniumHybridFrameworkProject\\qa\\testData\\testData.properties");
        try {
            FileInputStream testdataFis = new FileInputStream(testdataPropFile);
            testData.load(testdataFis);
        } catch (Throwable e){
            e.printStackTrace();
        }

    }

    public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }

        // Call the helper initializer
        initializeHelpers();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicit_Wait_Time));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_Load_Time));
        driver.get(prop.getProperty("Url"));                // driver.get("https://admin:admin@the-internet.herokuapp.com/");

        return driver;

    }

    public void initializeHelpers(){
        utilities = new Utilities();
        actions = new Actions(driver); // Initialize Actions class
        jsExecutor = (JavascriptExecutor) driver; // JavaScript Executor

        try{
            robot = new Robot();  //Initialize Robot Class
        } catch (AWTException e){
            e.printStackTrace();
        }

    }

//    public void initializeSelect(WebElement selectElement) {
//        try {
//            select = new Select(selectElement);
//        } catch (Exception e) {
//            e.printStackTrace();  // Handles any exception while initializing Select
//        }
//    }


}
