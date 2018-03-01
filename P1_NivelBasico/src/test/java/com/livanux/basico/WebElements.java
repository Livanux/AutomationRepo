package com.livanux.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    public static void main(String[] arg) {
        WebDriver driver;
        String baseURL = "http://live.guru99.com/index.php/";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        WebElement lnkTV = driver.findElement(By.linkText("TV"));
        lnkTV.click();

        WebElement  btnAddToCart = driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper " +
                "> div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button"));

        btnAddToCart.click();

        WebElement lblSubTotal = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/span/span"));

        if (lblSubTotal.getText().equals(expectedResult)) {
            System.out.printf("Prueba pasó. El resultado es: " + lblSubTotal.getText() + " es igual a " + expectedResult);
        } else {
            System.err.printf("Prueba Fallo. El resultado es: " + lblSubTotal.getText() + " NO es igual a " + expectedResult);
        }


        driver.close();
        }
    }
