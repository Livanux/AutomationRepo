package org.livanux.reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    static WebDriver driver;
    String baseURL = "http://newtours.demoaut.com/index.php";
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";


    public static WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void takeScreenshot(WebDriver driver, String fileWithPath) throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot)driver;
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(srcFile, destFile);
    }


}
