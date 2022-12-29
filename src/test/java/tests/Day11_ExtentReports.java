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

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

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

        // 4.   Customise System Info
        extentReports.setSystemInfo("Test Environment", "Smoke Test");
        extentReports.setSystemInfo("Application", "TechProEducation");
        extentReports.setSystemInfo("Team", "RedBulls");
        extentReports.setSystemInfo("SQA", "John");  // SQA ==> Software Query ?
        extentReports.setSystemInfo("Sprint Number", "SP205");

        // 5. Add more custom config info
        extentHtmlReporter.config().setReportName("TechPro Education LMS");
        extentHtmlReporter.config().setDocumentTitle("TechPro Education Extent Reports");

        // 6. Done With Configuration (attachReporter)
        extentReports.attachReporter(extentHtmlReporter);

        /*
        Summary:
                extentReports and extentHtmlReporter are used to add custom information
                on the report and create the report in a path.

                Then as assign it to extentTest as shown in the next step
         */

        // 7. Create extent test
        extentTest = extentReports.createTest("Extent Reporter","Smoke Test Report");
    }

    @Test
    public void extentReportTest(){
        // 8. Use reports
        driver.get("https://www.techproeducation.com");
        extentTest.pass("User is on TechPro Education Homepage");

        // Go to LMS
        driver.findElement(By.linkText("LMS LOGIN")).click();
        extentTest.pass("User is on LMS page.");

        // Verify the URL
        String lmsUrl = driver.getCurrentUrl();
        assertEquals("https://lms.techproeducation.com/", lmsUrl);
        extentTest.pass("URL assertion is done.");



    }

    @Test
    public void extentReportTest2(){
        // pass is used to mark the step as passed
        extentTest.pass("Test passed");

        // info is used to give an infrrmation about the step
        extentTest.info("Some information");

        // fail method is used to mark the step as failed
        extentTest.fail("Test failed");

        // skip method is used to mark the step as skipped maybe dev is still working on it etc.
        extentTest.skip("Skipped");

        // warning method is used to give working information
        extentTest.warning("Warning");

    }





    @AfterClass
    public static void extentReportTearDown(){
        //  9. Generate the report
        extentReports.flush();
    }




    /*
              1. Create Report Path
              2. Create HTML report in the path
              3. Create extent reports object for generating the Entire reports with configuration
              4. Customise System Info
              5. Add more custom config info
              6. Done With Configuration (attachReporter)
              7. Create extent test
              8. Use reports
              9. Generate the report

For this we used this repository

https://mvnrepository.com/artifact/com.aventstack/extentreports
8:19
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>4.0.9</version>
</dependency>
     */
}
