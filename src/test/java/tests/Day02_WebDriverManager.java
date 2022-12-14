package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_WebDriverManager {
    public static void main(String[] args) {

        // 1. Set Up ... usually we use following code
        // System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver");

        // But we no longer need it. Now we'll start using WebDriverManager API to Set up.. download from maven repository
        WebDriverManager.chromedriver().setup();

        // Rest is the same as before
        // Create driver
        WebDriver driver = new ChromeDriver();
        // maximise
        driver.manage().window().maximize();
        // go to the page
        driver.get("https://www.techproeducation.com");
        // close
        driver.quit();

    }
}
// -	Selenium testing - To do Selenium testing we created Maven project and uploaded Selenium
//                         Jar files/dependencies and Chrome Driver.
//-	Multiple drivers –creating different drivers is the concept of polymorphism ..