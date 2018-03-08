package org.livanux.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EjemploTestNG {
    WebDriver driver;
    String expectedResult  = "", actualResult = "";
    String baseURL = "http://newtours.demoaut.com/index.php";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void register(){
        driver.findElement(By.linkText("REGISTER")).click();
        expectedResult = "Register: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Title are not equals");
    }

    @Test(priority = 0, enabled = false)
    public void support(){
        driver.findElement(By.linkText("SUPPORT")).click();
        expectedResult = "Under Construction: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Title are not equals");
    }

    @BeforeMethod
    public void verifyHomeTitle(){
        driver.findElement(By.linkText("Home")).click();
        expectedResult = "Welcome: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Title are not equals");
    }
}