package org.livanux.intermedio;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class LogTest {
    WebDriver driver;
    String baseUrl = "http://healthunify.com/bmicalculator/";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    Logger log = Logger.getLogger(LogTest.class);

    @BeforeClass
    public void initializeComponent() {
        PropertyConfigurator.configure(System.getProperty(("user.dir")) + "\\resources\\log.properties");
    }

    @Test
    public void launchBrowser(){
        try {
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
            log.debug("Opening Website: " + baseUrl);
        }catch(WebDriverException we){
            log.error("WebDriver Failed" + we.getMessage());
        }catch(Exception e){
            log.fatal(e.getMessage());
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        log.info("Browser Closed.");
    }

    @Test(dependsOnMethods = "launchBrowser")
    public void BMICalculator(){
        try{
            log.info("Entering Weight");
            driver.findElement(By.name("wg")).sendKeys("90");

            log.info("Selecting Kg");
            new Select(driver.findElement(By.name("opt1")))
                    .selectByVisibleText("kilograms");

            log.info("Select Height in feet");
            new Select(driver.findElement(By.name("opt2")))
                    .selectByIndex(4);

            log.info("Select op3");
            new Select(driver.findElement(By.name("opt3")))
                    .selectByValue("10");


            log.info("Click on button calculate");
            driver.findElement(By.name("cc")).click();

            String SIUnit = driver.findElement(By.name("si")).
                    getAttribute("value");

            String USUnit = driver.findElement(By.name("us")).
                    getAttribute("value");

            String UKUnit = driver.findElement(By.name("uk")).
                    getAttribute("value");

            String note = driver.findElement(By.name("desc"))
                    .getAttribute("value");

            log.info("SI Unit" + SIUnit);
            log.info("US Unit" + USUnit);
            log.debug("UK Unit" + UKUnit);
            log.warn("Desc: " + note);

        }catch (NoSuchElementException ne){

            log.error("WebElement not found" + ne);

        }catch(WebDriverException we){
            log.error("Driver not found" + we.getMessage());

        }catch(Exception ex){
            log.fatal(ex.getMessage());
        }

    }
}

