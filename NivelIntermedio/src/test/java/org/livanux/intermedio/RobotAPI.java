package org.livanux.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotAPI {
    WebDriver driver;
    String greckoPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
    String baseUrl= "http://spreadsheetpage.com/index.php/file/C35/P10/";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", greckoPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void robotApiTest() throws AWTException, InterruptedException {
        WebElement lnkAnimateColors = driver.findElement(By.linkText("animatedcolors.xlsm"));
        lnkAnimateColors.click();

        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);

        for (int i = 0; i<=2; i++){
            robot.keyPress(KeyEvent.VK_DOWN);
        }
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

    }
}
