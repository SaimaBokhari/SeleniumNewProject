package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Day10_ScreenShotsOfEntirePage extends TestBase {

    /*
    Test case:
Create a class: ScreenShotsOfEntirePage
Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
When user type “uni” in the search box
And select the ‘United Kingdom’ from the suggestions
And click on submit button
Then verify the result contains ‘United Kingdom’
     */

    @Test
    public void takeScreenShotTest() throws IOException {
        // Go to https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        // Take a screenshot (through the REUSABLE METHOD)
        takeScreenShotOfPage();

        // Locate the searchbox; type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        takeScreenShotOfPage();

        // Select the ‘United Kingdom’ from the suggestions And click
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        takeScreenShotOfPage();

        // click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        // Verify the result contains ‘United Kingdom’
        assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        takeScreenShotOfPage();







    }
}
