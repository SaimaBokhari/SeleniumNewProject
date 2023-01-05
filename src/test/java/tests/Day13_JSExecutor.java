package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.IOException;
public class Day13_JSExecutor extends TestBase {

    /*
        Javascript Executor is an interface.
         */
    /*
    Given
        Go to https://techproeducation.com/"
    When
        Scroll into "WE OFFER"
    And
        Scroll into "LMS LOGIN"
    And
        Scroll into "WHY US"
    And
        Scroll back up to "Enroll Free"
    And
        Scroll all the way down
    And
        Scroll all the way up
    Then
        Take a screenshot of each step
     */

    @Test
    public void scrollIntoViewTest() throws IOException {
        // Go to https://techproeducation.com/"
        driver.get("https://techproeducation.com/");
        waitFor(2);  // reusable method from TestBase
        takeScreenShotOfPage();

        // Scroll into "WE OFFER"
        WebElement weOffer = driver.findElement(By.xpath("//*[.='we offer']"));

//        1. create JS EXECUTOR object
        JavascriptExecutor js =(JavascriptExecutor)driver;
//        2. execute the command
        waitFor(2);
//        scrolling We Offer element
        // js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[.='we offer']"))); // OR

        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        takeScreenShotOfPage();
        waitFor(2);

//        scrolling LMS LOGIN element
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.linkText("LMS LOGIN")));
        waitFor(2);
        takeScreenShotOfPage();

        /*
        To avoid repetition of the same method js.executeScript("arguments[0].scrollIntoView(true);"
        we create a reusable method scrollIntoViewJS() in our TestBase class and use it for next steps
         */

//        scrolling WHY US element by calling the REUSABLE METHOD
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(2);
        takeScreenShotOfPage();

//       scrolling back up to enroll free by calling the REUSABLE METHOD
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        waitFor(2);
        takeScreenShotOfPage();

        // scroll all the way down
        // We don;t need any webElement for this action
       //  js.executeScript("window.scrollTo(0, window.document.body.scrollHeight)");
        // We create A REUSABLE METHOD to avoid repeating the above step again and again

        scrollAllDownByJS();  // by calling the REUSABLE METHOD
        waitFor(2);
        takeScreenShotOfPage();

        // scroll all the way up by calling the REUSABLE METHOD
        scrollAllUpByJS();
        waitFor(2);
        takeScreenShotOfPage();

        // Take a screenshot of each step

    }

    @Test
    public void clickByJSTest(){
        // Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");
        waitFor(3);

        // Click on LMS LOGIN by using JavaScript Executor
        // Locate the element
//        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
//        lmsLogin.click();  // Selenium click
//        clickByJS(lmsLogin);   // JavaScript Click
        // OR

        // instead of creating object from JavaScript Executor again and again, we created a REUSABLE METHOD
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
        waitFor(2);
        takeScreenShotOfPage();
    }

    @Test
    public void clickByJSTest1() {
        // Go to http://www.uitestpractice.com/Students/Form
        driver.get("http://www.uitestpractice.com/Students/Form");
        waitFor(3);

        // Click on submit button
        //driver.findElement(By.xpath("//button[.='Submit']")).click();  // it failed

        // Using JS Executor reusable method
        clickByJS(driver.findElement(By.xpath("//button[.='Submit']")));

    }

    @Test
    public void typeInTheInputTest(){
        driver.get("https://techproeducation.com/");
        waitFor(3);

        // Type "QA" into the search box
       WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
 //      searchBox.sendKeys("QA");  // Selenium sendKey() method
       // WebElement searchBox = driver.findElement(By.name("s"));

        //setValueByJS(webElement, inputText);
        setValueByJS(searchBox, "QA");  // JS Executor setAttribute() ...  Reusable method


  /*
  Normally we use element.sendKeys("text") to type in an input.
    ALTERNATIVELY we can use js executor to type in an input
    arguments[0].setAttribute('value','admin123');  -> SAME AS sending password value to password box => element.sendKeys("admin123")

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

//        // Go to https://www.priceline.com/
//        driver.get("https://www.priceline.com/");

        // Get the value of CHECK-IN-DATE
        // getText() will not work to get the default date in check-in searchbox
        //getValueByJS("hotelDates");

        // Go to https://www.carettahotel.com/
        driver.get("https://www.carettahotel.com/");

        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click(); // we used this to handle security issues

        //Get the value of "CHECK-IN DATE"
        System.out.println("Selenium getText(): "+driver.findElement(By.id("checkin_date")).getText());//It does not take the default value of web element by using selenium getText()
        getValueByJS("checkin_date");



        /*
        Interview question:
            How you get the value of an input box?
        We can use js executor.
                How?
        I can get the element using js executor, and get the value of the element.
        For example, I can get the element by id, and use value attribute to get the value of in an input
        I have to do this, cause getText in this case does not return the text in an input
        getText() returns the normal text on the webpage, but the default value in any input isn't normal text
        e.g. the default value on a hotel check-in date.

         */

    }
    @Test
    public void changeBackgroundColorByJS(){

        // This method can be used to highlight something on screenshots for your report
        driver.get("https://www.priceline.com/");

       WebElement submit = driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']"));
       // Calling the Reusable Method
        changeBackgroundColorByJS(submit,"red");

        // add border
        addBorderWithJS(submit,"5px solid green");

    }
    @Test
    public void changeBackgroundColorAndBorderByJS(){

        // This method can be used to highlight something on screenshots for your report
        // Go to https://www.carettahotel.com/
        driver.get("https://www.carettahotel.com/");

        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click(); // we used this to handle security issues

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));

        // Calling the Reusable Method
        changeBackgroundColorByJS(submit,"red");

        // add border
        addBorderWithJS(submit,"5px solid green");

    }

    @Test
    public void changeBackgroundColorAndBorderByJS1(){

        // This method can be used to highlight something on screenshots for your report
        // Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");


        WebElement loginButton = driver.findElement(By.linkText("LMS LOGIN"));

        // Calling the Reusable Method
        changeBackgroundColorByJS(loginButton,"red");

        // add border
        addBorderWithJS(loginButton,"5px solid green");

    }
}
// colour or changing background is mainly a developer's job. We can use it to
// emphasize or highlight something important in our reports/screenshots

// https://www.geeksforgeeks.org/javascriptexecutor-in-selenium/
