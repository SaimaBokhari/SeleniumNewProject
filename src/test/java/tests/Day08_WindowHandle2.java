package tests;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Day08_WindowHandle2 extends TestBase {

    @Test
    public void newWindowTest() throws InterruptedException {
        // Open tecProEducation.com
        driver.get("https://www.techproeducation.com");

        // Do assertion
        String techProTitle = driver.getTitle();
        assertTrue(techProTitle.contains("Techpro Education"));

        // Get window 1 id
        String techProHandle = driver.getWindowHandle();

        // Open amazon on a new window
        driver.switchTo().newWindow(WindowType.WINDOW); // creates a new window and switches to that window automatically
        driver.get("https://www.amazon.com");

        // Do assertion
        String amazonTitle = driver.getTitle();
        assertTrue(amazonTitle.contains("Amazon"));

        // Get window 2 id
        String amazonHandle = driver.getWindowHandle();

        // Open linkedin on a new window

        driver.switchTo().newWindow(WindowType.WINDOW); // creates a new window and switches to that window automatically
        driver.get("https://www.linkedin.com");

        // Do assertion
        String linkedinTitle = driver.getTitle();
        assertTrue(linkedinTitle.contains("LinkedIn"));

        // Get window 3 id
        String linkedinHandle = driver.getWindowHandle();

        Thread.sleep(2000);
        // switch back to techpro
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        // switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        // switch back to linkedin
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin: " + driver.getCurrentUrl());


    }

    @Test
    public void newTabTest() throws InterruptedException {
        /*
   -- Open 3 new tabs and verify their titles --
    Given
        Open "https://www.techproeducation.com" on Tab 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW Tab 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW Tab 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
*/
        // Open tecProEducation.com
        driver.get("https://www.techproeducation.com");

        // Do assertion
        String techProTitle = driver.getTitle();
        assertTrue(techProTitle.contains("Techpro Education"));

        // Get tab 1 id
        String techProHandle = driver.getWindowHandle();

        // Open amazon on a new tab
        driver.switchTo().newWindow(WindowType.TAB); // creates a new tab and switches to that tab automatically
        driver.get("https://www.amazon.com");

        // Do assertion
        String amazonTitle = driver.getTitle();
        assertTrue(amazonTitle.contains("Amazon"));

        // Get tab 2 id
        String amazonHandle = driver.getWindowHandle();

        // Open linkedin on a new tab

        driver.switchTo().newWindow(WindowType.TAB); // creates a new tab and switches to that automatically
        driver.get("https://www.linkedin.com");

        // Do assertion
        String linkedinTitle = driver.getTitle();
        assertTrue(linkedinTitle.contains("LinkedIn"));

        // Get tab 3 id
        String linkedinHandle = driver.getWindowHandle();

        Thread.sleep(2000);
        // switch back to techpro
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        // switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        // switch back to linkedin
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin: " + driver.getCurrentUrl());


    }

}



/*
Test case for opening new windows:
Open 3 new windows and verify their titles --
    Given
        Open "https://www.techproeducation.com" on window 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW window 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW window 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin

 */
