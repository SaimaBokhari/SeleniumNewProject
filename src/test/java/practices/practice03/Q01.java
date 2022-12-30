package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q01 extends TestBase {
    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
  */
    @Test
    public void test(){
        //  Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        // Drag orange elements on proper boxes below them
        // 1. Locate sources and target webElements
        // sources
        WebElement price = driver.findElement(By.id("fourth"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));

        // targets
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement creditAccount = driver.findElement(By.id("loan"));

        // 2. Create actions object
        Actions actions = new Actions(driver);

        // 3. Now drag and drop
        actions.
                dragAndDrop(price,debitAmount).
                dragAndDrop(price,creditAmount).
                dragAndDrop(bank, debitAccount).
                dragAndDrop(sales, creditAccount).
                build().perform();

        // Verify they are dropped.
        WebElement successMessage = driver.findElement(By.id("equal"));
        assertTrue(successMessage.isDisplayed());

        // OR
        assertEquals("Perfect!",successMessage.getText());


    }

}
