package homework.secondHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HW4_Autocomplete extends TestBase {
    /*
When user goes to https://jqueryui.com/autocomplete/
And type Apple
Then select Applescript
     */
    @Test
    public void test(){
        // user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/ ");

        driver.switchTo().frame(0);

        // find the searchBox
        WebElement searchBox = driver.findElement(By.id("tags"));
        searchBox.sendKeys("Apple");

        // Then select Applescript
        driver.findElement(By.xpath("//*[@id='ui-id-1']//div")).click();


    }

    @Test
    public void test1(){
        driver.get("https://jqueryui.com/autocomplete/ ");
        driver.switchTo().frame(0);
        driver.findElement(By.id("tags")).sendKeys("Apple");
        WebElement appleScript = driver.findElement(By.id("ui-id-1"));
        appleScript.click();
    }
}
