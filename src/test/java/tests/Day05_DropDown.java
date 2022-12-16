package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day05_DropDown {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // User goes to the given browser
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


    }

    @Test
    public void dropDownTest(){

        // Select "Option 1" by index from the dropdown

        // Step 1:
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        //Step 2: Create 'Select' object
        Select select = new Select(dropDown);

        // Step 3: Select option by index/value/visible text
        select.selectByIndex(1);

    }

    @After
    public void tearDown(){
        driver.quit();
    }



}
