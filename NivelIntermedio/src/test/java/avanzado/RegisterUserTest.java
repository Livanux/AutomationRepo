package avanzado;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterUserTest {
    WebDriver driver;
    String expectedResult = null;
    String actualResult = null;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @Test(priority = 0)
    public void goToRegisterPage(){

    }

    @Test(priority = 1)
    public void registerAnUser(){

    }
}