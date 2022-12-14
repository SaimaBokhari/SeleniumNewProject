package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day03_Checkbox {

    WebDriver driver;

    @Before
    public void setUp() {
        //Usual steps to set up

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Implicit wait. .. just to make sure that driver doesn't fail in case page takes longer to open/or internet is slow
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // 15 seconds wait in case needed
        // maximise window
        driver.manage().window().maximize();

        // user goes to http://a.testaddressbook.com/sign_in
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");


    }

    // close the driver
    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void checkboxTest() {
        /*
Create a class : CheckBox

Create test method and complete the following task.
Go to https://testcenter.techproeducation.com/index.php?page=checkboxes
Locate the elements of checkboxes
Then click on checkbox1 if box is not selected
Then click on checkbox2 if box is not selected
Then verify that checkbox1 is checked.
         */

        // Locating checkbox 1 and checkbox 2
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));

        // Click on the checkbox 1 if it's NOT already selected
        if (!checkbox1.isSelected()) { //isSelected() returns true if checkbox is checked, returns false if checkbox is not checked
            checkbox1.click();
        }

        // Click on the checkbox 2 if it's NOT already selected
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        // Then verify that checkbox1 is checked.
        assertTrue(checkbox1.isSelected());


    }
}


