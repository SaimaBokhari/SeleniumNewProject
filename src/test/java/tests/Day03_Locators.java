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

public class Day03_Locators {

    WebDriver driver;


    @Before
    public void setUp(){
        //Usual steps to set up

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Implicit wait. .. just to make sure that driver doesn't fail in case page takes longer to open/or internet is slow
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // 15 seconds wait in case needed
        //Thread.sleep(3000);
        // maximise window
        driver.manage().window().maximize();

        // user goes to http://a.testaddressbook.com/sign_in
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    /*

Test case:

        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Locate the elements of Username textbox, Password textbox, and Login button
        Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
        Assert the login is successful
        Sign out from the page

     */

    @Test
    public void logInTest(){


        // Locate the elements of username and  password and login textbox
        WebElement userName = driver.findElement(By.name("username")); // Locating username by name
        WebElement password = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.tagName("button"));
        // we can use 'button' as tagName coz it's used only once on the page.
        // highlight any code -> right click -> press cmd f --> search appears at the bottom, write the word that you want to search

        // "sendKeys() is a method to type in the inputs automatically
        // to highlight and see how many times a word/tag is used,

        userName.sendKeys("Admin"); // sending the given data
        password.sendKeys("admin123");
        button.click();


        // This is 'log-in' automation code
        // To show manual testing is successful, take screenshots at every step.
        // To show automation code works successfully, do assertions


        // Assert the login is successful
        /*
        Verify that log-in is successful:
           1. We can use default page URL to do assertion
           2. Or we can locate a CORE ELEMENT on the default page to assert is that element is displayed on the page
              e.g.
              Login page: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
              Default page: https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
         */

        // first way:
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";  // to show that login was successful
        assertEquals("lOGIN FAILED",actualURL, expectedURL);  // print message if login is unsuccessful

        // another way of assertion
        boolean actualUrl = driver.getCurrentUrl().contains("dashboard");
        assertTrue(actualUrl);


        /*
         we can also use chain methods .. so we don't have to use containers
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();


        // but container ones are re-usable.. you find element once and re-use it again for other functions.. hence better

         */


        /*
        NOTES:
Almost every application is using web browser these days.
Web elements :  button, search box, text box, headers, title etc.
<a> is an anchor to go to a different page.
Web elements put all together make a web page.
Go to the page -> right click -> click on inspect to see the html codes of that whole page

What are LOCATORS?
we have 2 steps for WebElements:
      1. Identify the element
      2. Selenium identifies the elements using locators.

There are 8 selenium locators to locate an element.

id -> The most preferred one because of its uniqueness.
name
className
tagName
linkText
partialLinkText
xpath ->  There are multiple ways to write xpath
css   ->  There are multiple ways to write css

The first 3 are called ATTRIBUTE
     */


    }

    // close the driver
    @After
    public void tearDown(){
        driver.quit();
    }

}
