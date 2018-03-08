package org.livanux.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByItestContext {
    WebDriver driver;
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String baseUrl = "https://google.com";

    @BeforeTest(groups = {"A", "B"})
    public void setup(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest(groups = {"A"})
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider(ITestContext c){
        Object[][] groupArray = null;

        for(String group : c.getIncludedGroups()){
           if(group.equals("A")){
               groupArray = new Object[][]{
                       {"Ivan", "Google"},
                       {"Rozzy", "Yahoo"},
                       {"Emma Ivana", "Amazon"},
                       {"Ivan", "Google"},
                       {"Rozzy", "Yahoo"},
                       {"Emma Ivana", "Amazon"}
               };
               break;
           }else if(group.equals("B")){
               groupArray =  new Object[][]{
                       {"Mexico"},
                       {"Canada"},
                       {"Rusia"},
                       {"China"},
                       {"Albania"}
               };
               break;
           }
        }
        return groupArray;
    }

    @Test(dataProvider = "SearchProvider", groups = "A")
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

    @Test(dataProvider = "SearchProvider", groups = "B")
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
