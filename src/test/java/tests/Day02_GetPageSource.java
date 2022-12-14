package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    /*

//getPageSource() returns page source code as a string
//We might use this to verify if a certain text exist in the entire page
//Note that pageSource is not used a lot to do assertions
//Because it is too general and can lead false result

TEST CASE:
Test if amazon contains “Registry” on the homepage
Create a new class : GetPageSource
     */


    public static void main(String[] args) {
        // Set up
        WebDriverManager.chromedriver().setup();

        // Create driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // go to page
        driver.get("https://www.amazon.com");

        // Test if amazon contains “Registry” on the homepage
        // go to page
        String pageSource = driver.getPageSource();
        //System.out.println("pageSource = " + pageSource);

        // verify
        String expectedWord = "Registry";
        if(pageSource.contains(expectedWord)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            //System.out.println("pageSource = " + pageSource);
            System.out.println("EXPECTED WORD: " + expectedWord);
        }

        // close
        driver.quit();


        // Junit is an API to create a TESTING FRAMEWORK
        // TestNG .. NG stands for New Generation
    }
}
