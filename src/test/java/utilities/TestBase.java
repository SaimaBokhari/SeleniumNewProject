package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public abstract class TestBase {
    protected static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    //    @After
//    public void tearDown(){
//        driver.quit();
//    }

    // Auto Complete Reusable Method
    // This code is used for selecting and verifying our app auto complete search functionality
    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {

        // sending a KEYWORD Dynamically using first parameter
        driver.findElement(By.id("myCountry")).sendKeys(keyword);
        Thread.sleep(2000);
        // Selecting an option from the list Dynamically using SECOND parameter
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+textFromList+"']")).click();
        // Clicking on submit button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button']")).click();  // click on submit
        // Asserting if result contains the option that we selected Dynamically using SECOND parameter
        assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));

        // This reusable method is based for the given website... https://testcenter.techproeducation.com/index.php?page=autocomplete
        // You need to use the same LOGIC to create this reusable method for the company you work
        // Because your locators and xpath will be different
        // NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS, BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT
        // NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT
        // THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS

    }

    // Take a SCREENSHOT OF ENTIRE PAGE with this reusable method
    public void takeScreenShotOfPage() throws IOException {
        // To create a screenshot, follow these steps
        // Step 1. Take screenshot using getScreenshotAs() method (This method comes from SELENIUM API)
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // this is the image object, not the name of the image

        // Step 2. Save the screenshot in a path with DYNAMIC NAME

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // getting the current local date and time

        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+".png";
        // this is where we save the image, and every new screenshot will get a new name dynamically because
        // the seconds will be different everytime a new screenshot is taken

        FileUtils.copyFile(image, new File(path));



    }

}
