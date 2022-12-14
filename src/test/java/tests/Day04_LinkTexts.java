package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day04_LinkTexts {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    // linkText and partialLinkText are case-sensitive
    @Test
    public void LMSPage(){
        driver.get("https://techproeducation.com/");

        // Click on LMS Login
        // LMS Login is a link and its text is "LMS LOGIN"

        driver.findElement(By.linkText("LMS LOGIN")).click();

    }

    @Test
    public void LMSPagePartialLinkText(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.partialLinkText("LMS")).click();

        // Assert LMS page is visible

        // 1st way: using URL
        String expectedUrl = "https://lms.techproeducation.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("LMS LOGIN Page is not displayed!",expectedUrl,actualUrl);

        // 2nd way: By locating a CORE element on the expected page and assert
        WebElement loginElement = driver.findElement(By.linkText("Login/Register"));
        assertTrue(loginElement.isDisplayed()); // isDisplayed() returns True if element is on the page and vice versa
        //assertTrue(driver.findElement(By.linkText("Login/Register")).isDisplayed());

    }
}
