package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;

public class Day02_TitleVerification {
    /*

    1.Create a new class: VerifyTitleTest
	2.Navigate to techproeducation homepage
	3.Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

     */
    public static void main(String[] args) {
        /* Do manual testing first
            - Go to the page, put your arrow on the title of the page, take a screenshot, add to JIRA
            - go to page, right click, inspect, scroll all the way up to head section, take a screenshot, add to JIRA
         */

        // 1. Set Up
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver");

        // 2. Create Web Driver Object
        WebDriver driver = new ChromeDriver();

        // 3. Write Test Script

        // Always maximise the window first
        driver.manage().window().maximize();

        driver.get("https://www.techproeducation.com");

        // get the title
        String actualTitle =driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

        // Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL TITLE: " + actualTitle);
            System.out.println("BUT EXPECTED TITLE: " + expectedTitle);
        }

        // Close/Quit the browser
        driver.quit();





    }
}
