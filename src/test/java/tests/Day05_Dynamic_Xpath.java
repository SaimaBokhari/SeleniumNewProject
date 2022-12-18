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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day05_Dynamic_Xpath {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // User goes to the given page
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get("https://techproeducation.com/");


    }

    /*
        In some cases, values might change. So we need dynamic xpath.

         */

    @Test
    public void dynamicXpath(){
        //There are different xpaths to locate a text element on a page
        // The most common one is //tagName[@attribute='TEXT OF THE ELEMENT']
        // 1st XPATH => //*[.='TEXT OF THE ELEMENT']

        // Verify if "Username : Admin"  text is displayed on the page.
        // [.='Username : Admin'] returns the element whose text is Username : Admin
//        WebElement userNameText = driver.findElement(By.xpath("//*[.='Username : Admin']"));
//        assertTrue(userNameText.isDisplayed());  // or isEnabled() can also be used
//
//        // Verify if "Password : admin123" text is displayed on the page
//        WebElement passwordText = driver.findElement(By.xpath("//*[.='Password : admin123']"));
//        assertTrue(passwordText.isDisplayed());

        // 2nd XPATH => //*[(text()='TEXT OF THE ELEMENT')]
//        WebElement userNameText1 = driver.findElement(By.xpath("//*[(text()='Username : Admin')]"));
//        assertTrue(userNameText1.isDisplayed());
//
//        // 3rd XPATH => //*[contains(text(),'PARTIAL OR FULL TEXT OF THE ELEMENT')]
//        WebElement passwordText1 = driver.findElement(By.xpath("//*[contains(text(),'Passw')]")); // accepts partial text
//        assertTrue(passwordText1.isDisplayed());
//
//
//        WebElement pageContent = driver.findElement(By.xpath("//h2[@id='pageContent']"));  //input[@placeholder='Username']
//        WebElement pageContent1 = driver.findElement(By.xpath("//h2[contains(@id,'pageCont')]"));
//        WebElement pageContent2 = driver.findElement(By.xpath("//*[.='pageContent']"));
//        WebElement pageContent3 = driver.findElement(By.xpath("//h2[starts-with@id, 'pageC')]"));
//        assertTrue(pageContent.isDisplayed());


        // 2nd XPATH => //*[(text()='TEXT OF THE ELEMENT')]
       WebElement professionalText = driver.findElement(By.xpath("//*[(text()='Professional ')]"));
       assertTrue(professionalText.isDisplayed());

        // 3rd XPATH => //*[contains(text(),'PARTIAL OR FULL TEXT OF THE ELEMENT')]
        WebElement partialText =driver.findElement(By.xpath("//*[contains(text(),'Profes')]"));
        assertTrue(partialText.isDisplayed());

        /*
        Notes:

        - Css is a little faster and better but xpath is more common
        - xpath navigates through the DOM (html code on the browser. Document Object Model)
        -
        -

         */



    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
