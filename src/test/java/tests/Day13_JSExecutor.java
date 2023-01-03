package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.IOException;
public class Day13_JSExecutor extends TestBase {
    @Test
    public void scrollIntoViewTest() throws IOException {
        driver.get("https://techproeducation.com/");
        waitFor(3);
        takeScreenShotOfPage();

//        1. create js executor object
        JavascriptExecutor js =(JavascriptExecutor)driver;
//        2. execute the command
        waitFor(3);
//        scrolling We Offer element
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[.='we offer']")));
        takeScreenShotOfPage();
        waitFor(3);
//        scrolling LMS LOGIN element
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        //takeScreenshotOfPage();

        waitFor(3);
//        scrolling WHY US element
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();
        waitFor(3);

//        scrolling back up to enroll free by calling the REUSABLE METHOD
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        waitFor(3);
        takeScreenShotOfPage();

        // scroll all the way down
        scrollAllDownByJS();
        waitFor(3);
        takeScreenShotOfPage();

        // scroll all the way up
        scrollAllUpByJS();
        waitFor(3);
        takeScreenShotOfPage();

    }

    @Test
    public void clickByJSTest(){

        driver.get("https://techproeducation.com/");
        waitFor(3);
//        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
//        clickByJS(lmsLogin);
        // OR

        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
        waitFor(2);
        takeScreenShotOfPage();
    }

    @Test
    public void typeInTheInputTest(){
        driver.get("https://techproeducation.com/");
        waitFor(3);

       WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));

        setValueByJS(searchBox, "QA");


  /*
   INTERVIEW QUESTION : What are the selenium methods that you use to type in an input?
    - sendKeys()
    - with javascript executor we can change the value of the input

      */

    }


// We are not able to get the default value of the Check-in Check-out box
//This is one of the limitations of the selenium because normally,
// we cannot get the value of an attribute with selenium.
// We use following method:

    @Test
    public void getValueOfInputTest(){

        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");

        /*
        Interview question:
            How you get the value of an input box?
        We can use js executor.
                How?
        I can get the element using js executor, and get the value of the element.
        For example, I can get the element by id, and use value attribute to get the value of in an input
        I have to do this, cause getText in this case does not return teh text in an input
        getText() returns the normal text on the webpage, but the default value in any input isn't normal text
        e.g. the default value on a hotel check-in date.

         */

    }
    @Test
    public void colorByJS(){

        // This method can be used to highlight something on screenshots for your report
        driver.get("https://www.priceline.com/");

        changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"red");

        // add border
        addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"5px solid green");

    }

}

// https://www.geeksforgeeks.org/javascriptexecutor-in-selenium/
