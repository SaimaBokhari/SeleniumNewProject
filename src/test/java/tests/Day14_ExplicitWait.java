package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Day14_ExplicitWait extends TestBase {
    /*
    There are two(or three) main types of DYNAMIC WAITS in Selenium:

    1.Implicit wait: This is a global timeout for all elements on the page-waits. Applies automatically to the
    driver whenever driver is used. Throws NO SUCH ELEMENT EXCEPTION if element isn't found in the given time.
    2. Explicit wait: This is mostly used for a given condition for specific elements. This is local wait.
       Throws TIME OUT EXCEPTION if element isn't found in the given time.

       => When used together, Explicit Wait overrides the Implicit Wait.

    3. There is a third type as well FLUENT WAIT . But it's also considered subset of Explicit Wait because it's so similar.
        Throws TIME OUT EXCEPTION if element isn't found in the given time.

    Thread.sleep() is HARD WAIT. It's also called JAVA WAIT.
     */


    /*
        Given
            Go to https://the-internet.herokuapp.com/dynamic_loading/1
        When
            User clicks on the "Start" button
        Then
            Assert the "Hello World!" Shows up on the screen
         */

    @Test
    public void explicitWaitTest(){
        // Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // User clicks on the Start button
        // driver.findElement(By.id("start")).click();  // id didn't work
       driver.findElement(By.xpath("//div[@id='start']//button")).click();  // or "//button[.='Start']


        // verify the ‘Hello World!’ Shows up on the screen

        // Following piece of code fails because IMPLICIT WAIT is not able to handle the wait time and couldn't get the text for assertion
        // This is called SYNCHRONISATION issue.
//        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));  another xpath can be //h4[.='Hello World!']
//        assertEquals("Hello World!", helloWorld.getText());

        // Solution: Try EXPLICIT WAIT or FLUENT WAIT
        // Step 1: Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2: Use wait object with the appropriate method to handle the Synchronisation issue(wait issue)
        //  * waits UP TO 10 SECONDS for the xpath to be visible
        //  * returns the WEB ELEMENT  (so no need to locate the element separately bt findElement()
        //  * if the element is not found in the given time, it throws TIMEOUT Exception

        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        assertEquals("Hello World!", helloWorld.getText());

        /*
        If test fails,
         1. Check if the locator is correct (id, xpath etc.)
         2. Try explicit wait
         3. See if there's an iframe on the page
         */
    }

    @Test
    public void explicitWaitReusable(){
        // Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebElement helloElement = waitForClickability(By.xpath("//div[@id='finish']//h4"),10);
        assertEquals("Hello World!",helloElement.getText());

    }
}

/*
INTERVIEW QUESTIONS:

1. What are the selenium waits?
Implicit wait
Explicit wait
Fluent wait

NOTE: Thread.sleep(2000); is HARD WAIT / JAVA WAIT coz it comes from JAVA

2. Which one do you prefer? Why?
It depends on the test case. I already use implicit wait in my driver class.  But explicit wait works better. So I prefer explicit wait in some cases. For example, when I work with dynamically loaded elements, then explicit wait works better for waiting and locating the elements.

3. What might be the reason of test case failure?
   > Wrong locator type, wrong values,… DOUBLE CHECK THE LOCATOR
   > Not synchronized. Timing issue….ADD MORE TIME OR USE EXPLICIT WAIT
                 => Page is too slow, internet is slow, database is slow, hosting problem,…
   > Element may not be visible…PUT MORE TIMEOUT IT LOADING ISSUE, REVISE YOUR SCRIPT
   > Iframe…SWITCH TO IFRAME
   > Multiple window…SWITCH TO THE CORRECT WINDOW USING WINDOW HANDLERS
   > Alert….SWITCH, pop ups…, cookies…
   > Captcha code …. SELENIUM CANNOT HANDLE CAPCHA.NOTE WITH JAVA+SELENIUM, WE CAN HANDLE LIMITED CAPCHA

4. What do you do when your test case fails?
   > Read error message on the console. I see the error message and the line of the error. Then I can read which part of the code is fails. Error message gives me which class, which line, what error, …
   > Check the locators, time issue, element visibility, iframe, pop ups, …
   > Manual testing again to see my automation logic is correct. To also check the functional is working. Check you flow as well

5. Can you use implicit wait and explicit wait together?
Yes. Implicit wait is in driver class. When implicit in not enough, then I can use explicit wait. I have reusable methods for explicit waits

6. What is the difference between implicit and explicit wait?
Implicit is global(applies wait to the driver whenever driver is used), explicit is local(I have to call explicit wait every time for new element)
Explicit wait works with expected condition. We have to create WebDriverWait object. Has more option such as visibility, clickibility, text be

6. What is the difference between explicit and fluent wait?
In fact, they are similar, but there are a few differences:
Fluent wait does polling and can ignore the exceptions.

 */
