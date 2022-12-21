package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

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
}
