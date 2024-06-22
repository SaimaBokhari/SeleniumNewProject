package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;

import static org.junit.Assert.*;

public class Day11_ScreenshotOfSpecificElements extends TestBase {
    /*
    Given
        Go to https://www.techproeducation.com
    Then
        Assert the logo is displayed
    And
        Take screenshot  of logo
    And
        Take screenshot of social media icons
     */
    @Test
    public void screenshotTest() throws InterruptedException {
        // Go to https://www.techproeducation.com
        driver.get("https://www.techproeducation.com");

        // Assert the logo is displayed
        WebElement logo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        assertTrue(logo.isDisplayed());

        // Take screenshot  of logo as proof
        Thread.sleep(2000);
        // File image = logo.getScreenshotAs(OutputType.FILE);
        // OR we can create a reusable method in out TestBase class so we can call

        // Calling reusable method
        takeScreenShotOfTheElement(logo);

        // Take screenshot of social media icons
        WebElement socialMediaIcons = driver.findElement(By.xpath("//div[@data-id='19d2990']"));
        Thread.sleep(2000);
        takeScreenShotOfTheElement(socialMediaIcons);

    }
}
