package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Day11_ExtentReports extends TestBase {

    protected static ExtentReports extentReports;     // This class is used for file generation; creates an empty report template, to which we can add custom information
    protected static ExtentHtmlReporter extentHtmlReporter; // This class is used to add configuration information e.g. document title, report name etc.
                                                            // This is also responsible for storing the PATH of the report
    protected static ExtentTest extentTest;  // This class is used for logging information.
    // Some people call it      logger   as well.

    @BeforeClass
    public static void extentReportsSetUp(){
        // 1. Create Report Path

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // getting the current local date and time

        // Path is where we save the reports.
        String path = System.getProperty("user.dir")+ "/test-output/Reports/"+currentTime+"html_report.html";

        // 2. Create HTML report in the path
       extentHtmlReporter = new ExtentHtmlReporter(path);

       // 3. Create extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//      **********************

        // 4.   adding custom System Info
        extentReports.setSystemInfo("Test Environment", "Smoke Test");  // or Regression test , or UAT etc.
        extentReports.setSystemInfo("Application", "TechProEducation");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "RedBulls");
        extentReports.setSystemInfo("SQA", "John");  // SQA ==> Software Query ?
        extentReports.setSystemInfo("Sprint Number", "SP205");

        // 5. Add more custom configuration info
        extentHtmlReporter.config().setReportName("TechPro Education LMS");
        extentHtmlReporter.config().setDocumentTitle("TechPro Education Extent Reports");

        // 6. Done With Configuration... Now attach the two  (attachReporter)
        extentReports.attachReporter(extentHtmlReporter);

        /*
        Summary:
                extentReports and extentHtmlReporter are used to add custom information
                on the report and create the report in a path.

                Then we assign it to extentTest as shown in the next step
         */

        // Report is done. Now creating extent test to log info in the test case
        // 7. Create extent test
        extentTest = extentReports.createTest("Extent Reporter","Smoke Test Report");
    }

    @Test
    public void extentReportsTest(){
        // 8. Use reports
        driver.get("https://www.techproeducation.com");
        extentTest.pass("User is on TechPro Education Homepage");

        // Go to LMS
        driver.findElement(By.linkText("LMS LOGIN")).click();
        extentTest.pass("User is on LMS page.");

        // Verify the URL
        String expectedUrl = "https://lms.techproeducation.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("LMS LOGIN Page is not displayed!",expectedUrl,actualUrl);
        // Message will appear only if the test case fails

        extentTest.pass("Asserting the LMS Url");

        extentTest.pass("Test is complete.");


    }

    @Test
    public void extentReportsTest2(){
        // These methods work as sout body. But this logs/prints the results and message on HTML report instead of console.
        // pass is used to mark the step as PASSED
        extentTest.pass("Test passed");

        // info is used to give an information about that step
        extentTest.info("Some information");

        // fail method is used to mark the step as failed
        extentTest.fail("Test failed");

        // skip method is used to mark the step as skipped maybe dev is still working on it etc.
        extentTest.skip("Skipped");

        // warning method is used to give working information
        extentTest.warning("Warning");

    }





    @AfterClass
    public static void extentReportsTearDown(){
        //  9. Generate the report
        extentReports.flush();
    }




    /*

Extent reports is document generation API so that we can add some custom text on the report.
It's another tool which makes our testing framework more powerful.
Extent Report API is used to generate custom HTML reports.
We can add company or project specific information in the report configuration.
These reports can be uploaded on JIRA and shared with the team.

In short, Extent reports is a dependency that I use in my framework for generating custom html reports.
I get that dependency from the COMPANY internal depository.

Set Up:

For this we used this repository/dependency
https://mvnrepository.com/artifact/com.aventstack/extentreports
8:19
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>4.0.9</version>
</dependency>

1. Create Report Path
2. Create HTML report in the path
3. Create extent reports object for generating the Entire reports with configuration
4. Customise System Info
5. Add more custom config info
6. Done With Configuration (attachReporter)
7. Create extent test
8. Use reports
9. Generate the report

     */
}
