package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q04 extends TestBase {
    /*
   Given
        Go to https://www.gmibank.com/
   When
        Hover over "Premium" Deposit Package
   And
        Click on "Book Now"
   Then
        Verify url contains "services"
    */
    @Test
    public void gmiBankTest() throws InterruptedException {
        // Go to https://www.gmibank.com/
        driver.get("https://www.gmibank.com/");

        // Hover over "Premium" Deposit Package
        // Step 1: Locate the element
        WebElement premiumDeposit = driver.findElement(By.xpath("(//h4[@class='pricing-title'])[2]"));

        // Step 2: Create the actions object
        Actions actions = new Actions(driver);
        actions.moveToElement(premiumDeposit).perform();


        // Click on "Book Now"
         driver.findElement(By.linkText("Book Now")).click(); // OR
        //driver.findElement(By.xpath("(//a[.='Book Now'])[2]"));

        Thread.sleep(2000);
        // Verify url contains "services"
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("services"));

    }
}
