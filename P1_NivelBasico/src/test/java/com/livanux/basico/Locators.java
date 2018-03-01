package com.livanux.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] arg){
        WebDriver driver;
        String baseURL =  "http://live.guru99.com/index.php/";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        driver.findElement(By.linkText("TV")).click();

        driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper " +
                "> div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button")).click();

        actualResult = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/span/span")).getText();


        if(actualResult.equals(expectedResult)){
            System.out.printf("Prueba pasó. El resultado es: " +  actualResult + " es igual a " +  expectedResult );
        }else{
            System.err.printf("Prueba Fallo. El resultado es: " +  actualResult + " NO es igual a " +  expectedResult );
        }


        driver.close();

    }
}
