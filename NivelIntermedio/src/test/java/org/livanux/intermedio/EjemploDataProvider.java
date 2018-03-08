package org.livanux.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EjemploDataProvider {
    WebDriver driver;
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String baseUrl = "https://google.com";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"Stephany", "Google"},
                {"Juan", "Yahoo"},
                {"Rocio", "Gmail"},
                {"Julio", "Amazon"},
                {"Arturo", "Facebook"}
        };
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethod(String tester, String search) throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys(search);
       // System.out.println("Bienvenido -> " + tester + " Tu palabra de busqueda es: " + search);
        Thread.sleep(3000);

        String searchValue = txtSearch.getAttribute("value");
        //System.out.println("El valor de prueba es: " + searchValue + " y es igual a " + search);
        txtSearch.clear();
        Assert.assertTrue(searchValue.equals(search));
    }
}
