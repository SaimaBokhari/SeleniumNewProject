package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions03 extends TestBase {
    /*
    Given
        Go to "https://www.techproeducation.com"
When
        Scroll down with "PAGE_DOWN" key 3 times
And
        Scroll down with "ARROW_DOWN" key
And
        Scroll up with "PAGE_UP" key
And
        Scroll up with "ARROW_UP" key
     */

    @Test
    public void pageUpDownTest() throws InterruptedException {

        //  Go to "https://www.techproeducation.com"
        driver.get("https://www.techproeducation.com");

        // Step1: Create actions oj=bject
        Actions actions = new Actions(driver);

        // Step 2: Locate the webElement
        // we don't have any webElement in this case

        // Scroll down with "PAGE_DOWN" key 3 times
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // we can also use method chain
        // build() is recommended to use in method chain to make sure the connection between methods is strong
        // perform() is a MUST to use to execute the action.
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                build().
                perform();

        // build() is recommended; perform()  is mandatory

        // Scroll down with "ARROW_DOWN" key ... this key scrolls down less than PAGE_DOWN key
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();


        // Scroll up with "PAGE_UP" key
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        // Scroll up with "ARROW_UP" key... this key scrolls up less than PAGE_UP key
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();



    }


}
