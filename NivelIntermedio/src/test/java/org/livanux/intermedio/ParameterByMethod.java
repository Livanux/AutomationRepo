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

import java.lang.reflect.Method;

public class ParameterByMethod {
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
    public Object[][] getDataFromDataProvider(Method m){
        if(m.getName().equals("testMethodA")){
            return new Object[][]{
                    {"Ivan", "Google"},
                    {"Rozzy", "Yahoo"},
                    {"Emma Ivana", "Amazon"}
            };
        }else{
            return new Object[][]{
                    {"Mexico"},
                    {"Canada"},
                    {"Rusia"},
                    {"China"},
                    {"Albania"}
            };
        }
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethodA(String tester, String search) throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys(search);
        System.out.println("Bienvenido -> " + tester + " Tu palabra de busqueda es: " + search);
        Thread.sleep(3000);

        String searchValue = txtSearch.getAttribute("value");
        System.out.println("El valor de prueba es: " + searchValue + " y es igual a " + search);
        txtSearch.clear();
        Assert.assertTrue(searchValue.equals(search));
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethod(String search) throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys(search);
        Thread.sleep(3000);
        String searchValue = txtSearch.getAttribute("value");
        System.out.println("El valor de prueba es: " + searchValue + " y es igual a " + search);
        txtSearch.clear();
        Assert.assertTrue(searchValue.equals(search));
    }
}
