package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day04_xpath_css {
    /*
    xpaths are dynamic locators.

    There are 2 types of xpath:
    1. Absolute xpath: /
            Example of absolute path:

      For username on opensource-demo.con, the absolute xpath looks like this
            /html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input

      - Not recommended as it is long, complicated and breakable


    2. Relative xpath: //
        There are multiple ways of typing relative xpath
               Example of relative path:
               //tagname[@ attribute = 'value']

           - Recommended
     */


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void loginTest(){
        /*
  User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
  Locate the elements of Username textbox, Password textbox, and Login button
  Enter below username and password then click on login button
          Username :  Admin
          Password :  admin123

  Assert the login is successful

  */

        // User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Locate the elements of Username textbox, Password textbox, and Login button
        //Enter below username and password then click on login button
        //          Username :  Admin
        //          Password :  admin123

        // // The most common one is //tagname[@attribute='TEXT OF THE ELEMENT']

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // another way if there are multiple values ==> (//input)[3]   (//a)[1]



        //Assert the login is successful
        // Find the webElement that's specific for that page where you're supposed to be
        boolean actualUrl = driver.getCurrentUrl().contains("dashboard");
        assertTrue(actualUrl);


    }

    @Test
    public void loginTestCss(){
        /*
  User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
  Locate the elements of Username textbox, Password textbox, and Login button
  Enter below username and password then click on login button
          Username :  Admin
          Password :  admin123

  Assert the login is successful

  */

        // User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Locate the elements of Username textbox, Password textbox, and Login button
        //Enter below username and password then click on login button
        //          Username :  Admin
        //          Password :  admin123


        // ccsSelectors are simple. we use hash sign for id
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();


        //Assert the login is successful
        // Find the webElement that's specific for that page where you're supposed to be
        boolean actualUrl = driver.getCurrentUrl().contains("dashboard");
        assertTrue(actualUrl);


    }
    @After
    public void tearDown(){
        driver.quit();
    }

    /*
    HW:
     * How many locators are there?

     * What are they?

     * Which one do you prefer? Why?

     * What is difference between absolute xpath and relative xpath?

     * What is the difference between xpath and css selector?

     */

}
