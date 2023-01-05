package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementExceptionTest(){
        driver.get("https://techproeducation.com/");

        //Example of wrong locator
        driver.findElement(By.id("wrong-id"));  // NoSuchElementException



        /*
        Types of exceptions
        Remember ast least 5 of them
NoSuchElementException
TimeOutException
NullPointerException
InvalidSelectorException
StaleElementReferenceException
InvalidElementStateException
WebDriverException
ElementNotInteractableException
ElementClickInterceptedException
InvalidArgumentException
JavascriptException
RemoteDriverServerException
         */
    }
}
