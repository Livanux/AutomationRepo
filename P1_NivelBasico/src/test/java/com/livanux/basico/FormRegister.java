package com.livanux.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormRegister {

    static WebDriver driver;

    public static void main(String[] arg) {
        String baseURL = "http://newtours.demoaut.com/";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {

            driver.findElement(By.linkText("REGISTER")).click();
            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            txtFirstName.sendKeys("Ivan");
            Thread.sleep(2000);
            txtFirstName.clear();
            Thread.sleep(2000);
            txtFirstName.sendKeys("Ivan Gastelum");
            driver.findElement(By.name("address1")).sendKeys("Ensenada BC");
            Select drpCountry = new Select(driver.findElement(By.name("country")));
            drpCountry.selectByVisibleText("BAKER ISLAND");
            Thread.sleep(1500);
            driver.findElement(By.id("email")).sendKeys("ivangastelumtf@gmail.com");
            driver.findElement(By.name("password")).sendKeys("123");
            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            txtConfirmPass.sendKeys("123");
            txtConfirmPass.submit();
            WebElement lblUserCreated = driver.findElement(By.xpath("//*[contains(text(), \"Note: \")]"));

            System.out.println(lblUserCreated.getText().contains("ivangastelumtf@gmail.com")?"Prueba Paso!":"Prueba Fallo");

        }catch (NoSuchElementException ne){
            System.err.println("WebElement not found. " +  ne.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver fallo. " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.quit();
        }

    }
}
