package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2_GoogleSearchTest {
    /*
    HW 2:
Create a new class : GoogleSearchTest.
Create main method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google
     */
    public static void main(String[] args) {
        // Set up
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // When user goes to https://www.google.com/
        driver.get("https://www.google.com/");

        //Search for “porcelain teapot”
        WebElement searchBox= driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys("porcelain teapot");
        searchBox.click();


    }
}
