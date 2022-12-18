package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW3_Google {
    /*
    Create 3 different test methods using the following names. And go to google.
    - titleTest => Verify if google title = "Google"
    - imageTest => Verify if google image displays or not
    - gmailLinkTest => Verify if Gmail link is displayed or not
    - Close the  browser after each test
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Go to the given URL
        driver.get("https://www.google.com/");
    }

    @Test
    public void titleTest(){

        // titleTest => Verify if google title = "Google"
        String googleTitle = driver.getTitle();
        // Verify
        if (googleTitle.contains("Google")){
            System.out.println("Title contains the word Google");
        }else {
            System.out.println("Title doesn't contain the word Google");
        }
    }

    @Test
    public void imageTest(){
        // imageTest => Verify if google image displays or not
       WebElement image = driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        // Verify
//        if (image.isDisplayed()){
//            System.out.println("Image exists");
//        }else{
//            System.out.println("Image doesn't exist");
//        }

    }

    @Test
    public void gmailLinkTest(){
        // gmailLinkTest => Verify if Gmail link is displayed or not

        WebElement gmaillinkText = driver.findElement(By.linkText("Gmail"));

        //Verify
        if (gmaillinkText.isDisplayed()){
            System.out.println("Gmail link text exists.");
        }else{
            System.out.println("Gmail link text doesn't exist.");
        }

    }

    // Close the  browser after each test
    @After
    public void tearDown(){
        driver.quit();
    }

}
