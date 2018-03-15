package org.livanux.reports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(JyperionListener.class)
public class PdfEmail extends BaseClass{

    WebDriver driver = getDriver();

    @Test
    public void testOne(){
        driver.get("https://www.google.com.mx");
        Assert.assertTrue(true);
    }

    @Test
    public void testTwo(){
        driver.get("https://www.facebook.com/");
        Assert.assertTrue(true);
    }

    @Test
    public void testThree(){
        driver.get("https://titaniumsolutions.org/");
        Assert.assertTrue(true);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


    @AfterSuite
    public void sendEmail(){
        sendPdfByEmail("titaniumsoltest@gmail.com", "titaniumsoltest", "titaniumsoltest@gmail.com",
                "IVAN PDF Report", "Please find attached the PDF report");
    }


}
