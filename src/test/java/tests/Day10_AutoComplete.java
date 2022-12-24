package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Day10_AutoComplete extends TestBase {
    /*
    Test case: AutoComplete or AutoSuggest

Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
When user type “uni” in the search box
And select the ‘United Kingdom’ from the suggestions
And click on submit button
Then verify the result contains ‘United Kingdom’

     */
    @Test
    public void autoCompleteTest(){

        // Go to https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        // Locate the searchbox; type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");

        // Select the ‘United Kingdom’ from the suggestions And click
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

        // click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        // Verify the result contains ‘United Kingdom’
        assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));


    }

    @Test
    public void autoCompleteTestWithReusableMethod() throws InterruptedException {
        // Go to https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        searchAndSelectFromList("uni", "United Kingdom");  // Test Case 1
        searchAndSelectFromList("Pa", "Pakistan");  // Test Case 2
        searchAndSelectFromList("bah", "Bahamas");  // Test Case 3


    }

}
