package com.livanux.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsMouseKeyboad {
    static WebDriver driver;
    public static void main(String[] arg) {
        String baseURL = "http://www.facebook.com";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            WebElement txtUser = driver.findElement(By.id("email"));

            Actions builder = new Actions(driver);

            Action seriesOfActions = builder
                    .moveToElement(txtUser)
                    .click()
                    .keyDown(Keys.SHIFT)
                    .sendKeys("hola mundo")
                    .keyUp(Keys.SHIFT)
                    .doubleClick()
                    .contextClick(txtUser)
                    .build();

            seriesOfActions.perform();
            Thread.sleep(2000);

            System.out.printf("Prueba exitosa");

        }catch (NoSuchElementException ne){
            System.err.println("WebElement not found. " +  ne.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver falló. " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.close();
        }
    }
}