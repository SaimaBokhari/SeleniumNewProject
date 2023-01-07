package practices.practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
     */

    @Test
    public void test(){
        // Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenShotOfPage();

        // Click on Ajax Loader
        driver.findElement(By.id("button3")).click();
        takeScreenShotOfPage();

        // Click on "Click Me!" button
        // driver.findElement(By.id("button1")).click();  // Implicit wait works here

        waitForClickability(By.id("button1"), 5).click();//explicit wait
        takeScreenShotOfPage();

       // Assert that button is clicked
        String text = waitForVisibility(By.xpath("//h4"),3).getText();
        System.out.println(text);


        assertTrue(text.contains("Well Done"));
        // Take screenshot after each step




    }
}
