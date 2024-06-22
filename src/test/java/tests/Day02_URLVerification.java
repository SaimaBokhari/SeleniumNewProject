package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    /*
    1.Create a new class: VerifyURLTest
	2.Navigate to TechProEducation homepage
	3.Verify if homepage url is “https://techproeducation.com/”
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


        // Verify if google homepage url is “https://techproeducation.com/”
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techproeducation.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL URL: " + actualURL);
            System.out.println("BUT EXPECTED URL: " + expectedURL);
        }

        // Close/Quit the browser
        driver.quit();

        /*
        What is your approach for AUTOMATION?
             - I read the acceptance criteria carefully (that SHOULD ALWAYS be the starting point)
             - I then create my test cases
             - Then I do MANUAL TESTING first. (it helps us understand the application behaviour)
             - If all good, I start automation script and run it.
             - If I find a bug/defect, then I talk to dev, (Or follow the company culture) Dev fixes the issue, then I retest manually again
                If all good, I complete automation script.
             - When Automation is complete, I prepare the report for that user story.
               In fact, my Automation script generates html reports for us, I upload those reports to JIRA.
             - For my manual test cases, I manually take screenshots, prepare reports and attach them to JIRA

        What do you do when your Automation test case PASS?
             - I prepare report and upload to JIRA


        What do you do when your test case FAILS?
             - Retest to make sure the failure is not coz of my typo
             - It can be a data issue, typo, documentation or it can be a real bug.
             - If there is a real bug, then talk to the dev and let them fix
             - After the fix, we retest. If the test case passes, we upload to Jira


        What do you do when you find a bug?
             - Same as above

         If the user story passed in first sprint, but failed in lets 3rd or 4th sprint,
         we have 2 options:
             1. Create a bug ticket and assign to a dev by adding the same user story again. OR
             2. If the bug is big, we can create a new user story (decided by the team usually)
                  e.g. page title should be there, assign to a dev, once fixed, we retest it.



         */







    }
}
