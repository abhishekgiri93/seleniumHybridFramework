package com.seleniumHybridFrameworkProject.qa.utils;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Utilities {

    public static final int implicit_Wait_Time = 10;
    public static final int explicit_Wait_Time = 20;
    public static final int page_Load_Time = 30;
    private Properties testData;
    public WebDriverWait wait;


    public static String generateTimeStamp() {
        Date date = new Date();
        String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
        return "abhishekgiri93" + timeStamp + "gmail.com";
    }

    public static Object[][] getTestDataFromExcel(String sheetName) {
        File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\seleniumHybridFrameworkProject\\qa\\testdata\\seleniumHybridFrameworkProjectTestData.xlsx");
        XSSFWorkbook workbook = null;
        try {
            FileInputStream fisExcel = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fisExcel);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data1 = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            // why i+1 because we want to read the data from index 1 not
            // from index 0 where phone number text is written
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case STRING:
                        data1[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data1[i][j] = Long.toString((long) cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data1[i][j] = cell.getBooleanCellValue();
                        break;
                }

            }

        }
        return data1;
    }

    // Method to load properties file
    public void loadTestDataProperties() {
        testData = new Properties();
        try {
            File testdataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\seleniumHybridFrameworkProject\\qa\\testData\\testData.properties");
            FileInputStream testdataFis = new FileInputStream(testdataPropFile);
            testData.load(testdataFis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a property value
    public String getProperty(String key) {
        if (testData == null) {
            loadTestDataProperties();  //load properties file first if not loaded
        }
        return testData.getProperty(key);
    }

    // Method to process all image elements
    public void processImages(List<WebElement> images) {
        int index = 1;
        for (WebElement image : images) {
            String imageUrl = image.getAttribute("src");
            try {
                // Use the isImageBroken method to check if the image is broken
                if (isImageBroken(imageUrl)) {
                    System.out.println("Image " + index + " is broken! URL: " + imageUrl);
                } else {
                    System.out.println("Image " + index + " is working fine. URL: " + imageUrl);
                }
            } catch (IOException e) {
                System.out.println("Error checking image " + index + " (URL: " + imageUrl + "). Error: " + e.getMessage());
            }
            index++;
        }
    }

    public boolean isImageBroken(String imageUrl) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            // Create the HTTP GET request
            HttpGet request = new HttpGet(imageUrl);
            // Execute the request and get the response
            try (CloseableHttpResponse response = client.execute(request)) {
                // Get the status code from the response using the getCode() method of the HttpResponse
                int statusCode = response.getCode();  // Correct usage here
                // Return true if the status code is not 200 (OK), indicating a broken image
                return statusCode != 200;
            }
        }
    }

    // Lazy Initialization - wait object is created only when first used
    public WebDriverWait getWait(WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(explicit_Wait_Time));
        }
        return wait;
    }


}
