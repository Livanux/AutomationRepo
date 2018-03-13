package org.livanux.intermedio;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScritpSelenium {

    private WebDriver driver;
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String expectedResult = "";
    String actualResult = "";
    String baseUrl = "http://newtours.demoaut.com/mercurywelcome.php";
    private JavascriptExecutor js;

    String pageLoadStatus ="";


    private boolean highLight(WebElement element){
        js = (JavascriptExecutor)driver;
        for (int iCnt = 0; iCnt < 3; iCnt++ ){
            try{
                js.executeScript("arguments[0].setAttribute('style' , 'background: #56ad46')", element);
                Thread.sleep(1000);
                js.executeScript("arguments[0].setAttribute('style' , 'background: ')", element);
            }catch(JavascriptException je){
                System.err.println("JavasScript | highLight  | Exception des: " + je.getMessage());
                return false;
            }catch(InterruptedException ie){
                System.err.println(ie.getMessage());
                return false;
            }
        }
        return true;
    }

    private boolean scrollWindow(){
        try {
            js = (JavascriptExecutor) driver;
            //Scroll up(0,-250)  down (0,250)
            js.executeScript("window.scrollBy(0,250)");
        }catch(JavascriptException je) {
            System.err.println("JavasScript | scrollWindow  | Exception des: " + je.getMessage());
            return false;
        }

        return true;
    }

    private boolean waitForPageToLoad(){
        try {
            do {
                js = (JavascriptExecutor) driver;
                pageLoadStatus = (String)js.executeScript("return document.readyState");
            }while(!pageLoadStatus.equals("complete"));

        }catch(JavascriptException je) {
            System.err.println("JavasScript | waitForPageToLoad  | Exception des: " + je.getMessage());
            return false;
        }

        return true;
    }


    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        waitForPageToLoad();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 0)
    public void goToRegisterPage(){
        WebElement lnkRegister = driver.findElement(By.linkText("REGISTER"));
        Assert.assertTrue(highLight(lnkRegister));
        js.executeScript("arguments[0].click();", lnkRegister);

        expectedResult  = "Register: Mercury Tours";
        actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertTrue(scrollWindow());


    }

    @Test(priority = 1)
    public void registerAUser(){

        WebElement txtName = driver.findElement(By.name("firstName"));
        highLight(txtName);
        txtName.sendKeys("Iván Gastelum");

        WebElement ddlCountry = driver.findElement(By.name("country"));
        highLight(ddlCountry);
        new Select(ddlCountry).selectByValue("100");

        WebElement txtUserName = driver.findElement(By.id("email"));
        highLight(txtUserName);
        txtUserName.sendKeys("livanux");

        highLight(driver.findElement(By.name("password")));
        driver.findElement(By.name("password")).sendKeys("123");

        WebElement txtConfirmPwd = driver.findElement(By.name("confirmPassword"));
        highLight(txtConfirmPwd);
        txtConfirmPwd.sendKeys("123");
        txtConfirmPwd.submit();

        Assert.assertTrue(waitForPageToLoad());
        Assert.assertTrue(scrollWindow());

        highLight(driver.findElement(By.xpath("//*[contains(text(), 'Note: ')]")));
    }





}
