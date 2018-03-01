package com.livanux.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
    static WebDriver driver;
    static String baseURL = "http://popuptest.com/popuptest2.html";
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void close(){
        driver =  new ChromeDriver();
        driver.navigate().to(baseURL);
        driver.close();
    }

    public static void quit() throws InterruptedException {
        driver =  new ChromeDriver();
        driver.get(baseURL);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",  chromePath);
        quit();
    }
}