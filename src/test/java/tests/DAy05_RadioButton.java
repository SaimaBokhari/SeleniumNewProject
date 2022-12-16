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

public class DAy05_RadioButton {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");

    }
    @Test
    public void radioButtonTest() throws InterruptedException {
        // Radio Button means selecting only one button at a time


        // Click on yellow
        Thread.sleep(2000); // We add Hard wait/Java wait to see the process
        WebElement yellowButton = driver.findElement(By.id("yellow"));
        yellowButton.click();
        // Or we can also use cssSelector by id
        // WebElement yellowButton = driver.findElement(By.cssSelector("#yellow")).click();

        // Assert that yellow is selected
        assertTrue(yellowButton.isSelected());

        // Click on Black
        Thread.sleep(2000);
        WebElement blackButton = driver.findElement(By.id("black"));
        blackButton.click();

        // Assert that black is selected
        assertTrue(blackButton.isSelected());

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
