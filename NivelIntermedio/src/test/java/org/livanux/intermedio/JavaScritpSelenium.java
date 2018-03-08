package org.livanux.intermedio;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScritpSelenium {

    private WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String baseUrl = "newtours.demoaut.com";
    private JavascriptExecutor js;

    String pageLoadStatus ="";


    private boolean highLight(WebElement element) throws InterruptedException {
        js = (JavascriptExecutor)driver;
        for (int iCnt = 0; iCnt < 3; iCnt++ ){
            try{
                js.executeScript("arguments[0].setAttribute('style' , 'background: red')", element);
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



}
