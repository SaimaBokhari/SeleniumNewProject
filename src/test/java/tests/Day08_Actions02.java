package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day08_Actions02 extends TestBase {
    /*
        Given
                Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        When
                Hover over "Hover Div"
        And
                Click on “Can you click me?” link.
        Then
                Verify the text "Action Complete".
        */

    @Test
    public void hoverOverTest(){
        //  Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        // Hover over "Hover Div"
        // Step 1: Create actions object
        Actions actions = new Actions(driver);

        // Step 2: Locate the webElement you want to hover over
        WebElement hoverDiv = driver.findElement(By.id("hoverdivpara"));

        // Step 3: Use actions object with proper method.
        actions.moveToElement(hoverDiv).perform();

        // Click on “Can you click me?” link.
        driver.findElement(By.id("hoverlink")).click();

        // Verify the text "Action Complete".
        String resultText = driver.findElement(By.xpath("//h1")).getText();
        assertEquals("Action Complete", resultText);

    }

    @Test
    public void amazonHoverTest() throws InterruptedException {

        /*
        Create test method: hoverOver() and test the following scenario
        Given user is on the https://www.amazon.com/
        When user clicks on "Account" link
        Then verify the page title contains "Your Account"
         */

        driver.get("https://www.amazon.com/");

        // Hover over "Account"
        // Step 1: Create actions object
        Actions actions = new Actions(driver);

        // Step 2: Locate the webElement
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));

        // Step 3:
        actions.moveToElement(accountList).perform();

        // Click on "Account" link
        Thread.sleep(2000);
        driver.findElement(By.linkText("Account")).click();

        Thread.sleep(2000);

        // Verify the page title contains "Your Account"
        assertTrue(driver.getTitle().contains("Your Account"));


    }
}
