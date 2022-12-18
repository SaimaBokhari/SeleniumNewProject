package practices;

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

import static org.junit.Assert.assertEquals;

public class Q04 {
    // ...Practice 4...
    // Create chrome driver by using @Before annotation and WebDriverManager
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculator under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Assert the result
    // Print the result
    // Close the browser by using @After annotation

    WebDriver driver;

    // Create chrome driver by using @Before annotation and WebDriverManager
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Go to THE GIVEN url
        driver.get("https://testpages.herokuapp.com/styled/index.html");


    }
    @Test
    public void additionTest() {
        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("5");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("4");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result = driver.findElement(By.id("answer")).getText();

        // Assert the result
        assertEquals("9",result);

        // Print the result
        System.out.println(result);

        // Close the browser by using @After annotation

    }
    @Test
    public void divisionTest(){
        // from the above test case

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("24");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("4");

        // Select "divide" operation ... by choosing the dropDown operation

        WebElement functionDropDown = driver.findElement(By.id("function"));
        new Select(functionDropDown).selectByVisibleText("divide");


        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result = driver.findElement(By.id("answer")).getText();

        // Assert the result
        assertEquals("6",result);

        // Print the result
        System.out.println(result);

        // Close the browser by using @After annotation


    }

    @After
    public void tearDown(){
        driver.quit();

    }
}
