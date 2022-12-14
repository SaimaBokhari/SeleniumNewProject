package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {

        // 1. Set up Chrome Driver (with two parameters: Webdriver, path of chromedriver
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver");

        // 2. Create Chrome Driver Object
        WebDriver driver = new ChromeDriver();

        // 3. Now that we created Web Driver, we can automate Web Application

        driver.get("https://www.techproeducation.com");

        /*

         // get() is one of the most important method used

        driver.get("url");              //Navigate to the page

        driver.getTitle();              //Returns the title of the page  //Title in browser.

        driver.getCurrentUrl();         //Returns the URL of the page

        driver.getPageSource();         //Returns the page source of the page  //right click on page-->view page source

        driver.getWindowHandle();       //Returns the unique ID of the active window

        driver.getWindowHandles();      //Returns the unique ID of the all active windows

        driver.navigate().to("url");     //Navigate to the page

        driver.manage().window().maximize();    //Maximizes the window
         */


    }
}
