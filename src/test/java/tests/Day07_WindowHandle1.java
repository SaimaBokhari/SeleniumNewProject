package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day07_WindowHandle1 extends TestBase {
    /*
Create a new Class Tests package: WindowHandleExample
Method name:windowHandle
Given user is on the https://the-internet.herokuapp.com/windows
Then user verifies the text : “Opening a new window”
Then user verifies the title of the page is “The Internet”
When user clicks on the “Click Here” button
Then user verifies the new window title is “New Window”
Then user verifies the text:  “New Window”
When user goes back to the previous window and then verifies the title : “The Internet”
     */

    /*
    Summary notes:
    - Multiple windows may open when there's a link that opens in a new TAB or WINDOW
    - We use windowHandle() to get the current window id or windowHandles() to get all the open windows ids
    - We use set of list to get all window ids and switch to the desired window using loop and if condition

     */

    @Test
    public void windowHandleTest() throws InterruptedException {
//        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

//        Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("Opening a new window", window1Text);

//        Then user verifies the title of the page is “The Internet”
        assertEquals("The Internet", driver.getTitle());

//        GETTING THE WINDOW 1 HANDLE(UNIQUE PAGE ID)
        String window1Handle = driver.getWindowHandle(); //RETURNS THE CURRENT WINDOW ID
        System.out.println(window1Handle);

//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();


        // When we clicked, new window opened. But the driver is still in first window.
        // First we need to switch to the new window and then we will be able to test anything

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);

        // Logic: driver is on the window1, loop through all windows, switch to the one that in NOT WINDOW1 HANDLE
        for (String eachHandle : allWindowHandles){  // looping through the windows
            if (! eachHandle.equals(window1Handle)){ // if we are not in windows 1 (means windows 2)
                driver.switchTo().window(eachHandle); // then switch the window 2
            }
        }


          // At this point, driver is switched to windows 2
        String window2Handle = driver.getWindowHandle();  // will get window 2 handle
//        Then user verifies the text:  “New Window”
        String window2Text = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("New Window", window2Text);

        Thread.sleep(3000);
//        When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);  // switches back to window 1 because now driver already knows the window1 handle
        assertEquals("The Internet", driver.getTitle());

//        Switch back to window 2
        driver.switchTo().window(window2Handle);

        Thread.sleep(3000);

//        Switch back to window 1
        driver.switchTo().window(window1Handle);

 //        Switch back to window 2
        driver.switchTo().window(window2Handle);

        Thread.sleep(3000);

//        Switch back to window 1
        driver.switchTo().window(window1Handle);

    }

}
