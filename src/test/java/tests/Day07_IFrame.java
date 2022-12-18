package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Day07_IFrame extends TestBase {
    /*
    Create a class: IFrame
Create a method: iframeTest
Go to https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “This text box is inside the iframe”
Verify the text Elemental Selenium text is displayed on the page
     */


    @Test
    public void iframeTest(){
        // Go to the given URL
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Verify the Bolded text contains “Editor”
        // Header is not in the iframe, so no need to switch to iframe
        String header = driver.findElement(By.xpath("//h3")).getText();
        assertTrue(header.contains("Editor"));

        // text box is inside the iframe so we need to switch first
        // There are 3 ways to switch to an iframe
       // driver.switchTo().frame(0);  // 1. by index.... index starts at zero ... fast but breakable
        driver.switchTo().frame("mce_0_ifr");  // 2. by id/name .... PREFERRED ONE
       // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));  // 3. by webElement of the iframe

        // Locate the text box
        // we are inside the iframe, so locate the element now
        WebElement textBox = driver.findElement(By.xpath("//p"));

        //Delete the text in the text box
        textBox.clear();

        // Type “This text box is inside the iframe”

        textBox.sendKeys("This text box is inside the iframe");

        // Verify the text 'Elemental Selenium' text is displayed on the page
        // we need to switch back to the parent/root because driver is inside the iframe until now.
        // But the text 'Elemental Selenium' is outside the iframe
        driver.switchTo().parentFrame();  // this will take only 1 step up
//        driver.switchTo().defaultContent(); // this will take to the html level...completely out

        assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

        /*
        Interview question:

        What might be the reason(s) for your test case to fail?
           - There might be wait problem; the page may be very slow to load
              Internet might be slow. (Solution: Put some explicit wait in selenium)
           -  Locator might be incorrect.
              (Solution: Double check locator and fix it if needed)
           - Data issue. Typo in our expected values.
              (Solution: If there is any documentation issue, we can talk to BA to fix the document
                         and then we can use correct expected values)
           - Maybe there is an iframe on the page
              (Solution: We first need to switch to the frame)
           - Maybe there is an alert on the page
              (Solution: We first need to handle the alert by accepting or dismissing)
           - Maybe the page opens in a new tab or window
              (Solution: We first need to switch the target window)
           - It may be a real bug that is caused by the latest codes.
              (Solution: We discuss the issue with the team then raise a bug ticket if needed)

         */


    }
}

