package com.livanux.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFrame {
    static WebDriver driver;

    public static void main(String[] arg) {
        String baseURL = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        WebDriverWait waitVar =  new WebDriverWait(driver, 10);
        driver.get(baseURL);
        driver.manage().window().maximize();
        int a = 82;
        try {

            driver.switchTo().frame("iframeResult");
            WebElement btnTry = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(1500);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alrWindow =  driver.switchTo().alert();
            String altText = alrWindow.getText();
            System.out.println(altText);
            alrWindow.sendKeys("Ivan Gastelum");
            alrWindow.accept();

            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Ivan")?finalText:"Test fallida");

        }catch (NoSuchElementException ne){
            System.err.println("WebElement not found. " +  ne.getMessage());
        }catch (NoSuchFrameException nf){
            System.err.println("No se encontro el frame " + nf.getMessage());
        }catch (NoAlertPresentException na){
            System.err.println("No se encontro la alerta " + na.getMessage());
        }catch (TimeoutException te){
            System.err.println("Tiempo de espera excedido " + te.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver failed. " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.quit();
        }


    }
}
