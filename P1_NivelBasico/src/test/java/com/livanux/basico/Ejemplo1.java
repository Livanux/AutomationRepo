package com.livanux.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {

    public static void main( String[] arg){

        WebDriver driver;
        String baseURL = "http://newtours.demoaut.com/";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver =  new ChromeDriver();

        driver.get(baseURL);

        actualResult = driver.getTitle();

/*
        if (actualResult.equals(expectedResult)){
            System.out.printf("Prueba paso!");
        }else{
            System.out.printf("Prueba fallo!");
        }
*/

        System.out.println( actualResult.equals(expectedResult) ? "Prueba paso: " + actualResult : "Prueba Fallo: " + actualResult);
        driver.close();
    }
}
