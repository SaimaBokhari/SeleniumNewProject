package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Day01_BasicNavigations {
    public static void main(String[] args) {
        // 1. Set Up
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver");

        // 2. Create Web Driver Object
        WebDriver driver = new ChromeDriver();



        // 3. Write Test Script .. using the user story and steps given below


        // maximise the window
        driver.manage().window().maximize();


        // Open home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");

       // On the same class, Navigate to amazon home page https://www.amazon.com/
        // we can use two ways:
        // 1 way:
        // driver.get("https://www.amazon.com/");

        // 2nd way:
        driver.navigate().to("https://www.amazon.com/");

        // Navigate back to walmart
        driver.navigate().back();

        // Navigate forward to amazon
        driver.navigate().forward();

        // Refresh the page
        driver.navigate().refresh();

        // Close/Quit the browser
        //driver.close(); // this closes only the last active one
        // or
        driver.quit();  // this is stronger.. this will close all windows and tabs




         /*
        User Story:
        - When user goes to walmart
        - Then goes to amazon
        -

         */

        /*
        Steps:
Create a new class under : BasicNavigations
Create main method
Set Path
Create chrome driver
Maximize the window
Open walmart home page https://www.walmart.com/.
On the same class, Navigate to amazon home page https://www.amazon.com/
Navigate back to walmart
Navigate forward to amazon
Refresh the page
Close/Quit the browser
         */




    }
}
