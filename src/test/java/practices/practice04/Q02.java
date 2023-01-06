package practices.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q02 extends TestBase {
    /*
  Given
      Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
  When
      Click on "click me" button
  Then
      Verify that "Event Triggered"
   */

    @Test
    public void test(){
        // Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        // Click on "click me" button
        WebElement clickButton = driver.findElement(By.id("growbutton"));
        // waitForClickability(clickButton, 5).click(); // explicit wait .. this didn't work either
        // fluentWait("//button[@id='growbutton']", 10, 2).click();  // fluentWait didn't work either

        waitFor(4);   // So we used Hard wait .. it worked
        clickButton.click();

        // Verify that "Event Triggered"
        String buttonStatus = driver.findElement(By.id("growbuttonstatus")).getText();
        assertEquals("Event Triggered", buttonStatus);

    }
}
