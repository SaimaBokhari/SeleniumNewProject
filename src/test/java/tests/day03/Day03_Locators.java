package tests.day03;

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

public class Day03_Locators {

    WebDriver driver;


    @Before
    public void setUp(){
        //Usual steps to set up

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Implicit wait. .. just to make sure that driver doesn't fail in case page takes longer to open/or internet is slow
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // 15 seconds wait in case needed
        // maximise window
        driver.manage().window().maximize();

        // user goes to http://a.testaddressbook.com/sign_in
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    @Test
    public void logInTest(){
        /*

Test case:

Create a class : LocatorsIntro
Create test method locators
user goes to http://a.testaddressbook.com/sign_in
Locate the elements of email textbox, password textbox, and signin button
Enter below username and password then click sign in button
Username :  testtechproed@gmail.com
Password : Test1234!
Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
Verify the Addresses and Sign Out  texts are displayed
Find the number of total link on the page
Sign out from the page

we used this website as the above wasn't working
https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

     */

        // Locate the elements of username and  password textbox
        WebElement userName = driver.findElement(By.name("username")); // Locating username by name
        userName.sendKeys("Admin"); // typing in the given name

        // for password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // "sendKeys() is a method to type in the inputs automatically
        // to highlight and see how many times a word/tag is used,
        // highlight any code -> right click -> press cmd f --> search appears at the bottom, write the word that you want to search

        // Locating the button and click on it
        // we can use 'button' as tagName coz it's used only once on the page.
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();


        // This is 'log-in' automation code
        // To show manual testing is successful, take screenshots at every step.
        // To show automation code works successfully, do assertions


        /*
        Verify that log-in is successful:
           1. We can use default page URL to do assertion
           2. Or we can locate a CORE ELEMENT on the default page to assert is that element is displayed on the page
              e.g.
              Login page: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
              Default page: https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
         */

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";  // to show that login was successful

        assertEquals("lOGIN FAILED",actualURL, expectedURL);  // print message if login is unsuccessful



        /*
         we can also use chain methods .. so we don't have to use containers
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();


        // but container ones are re-usable.. you find element once and re-use it again for other functions

         */


        /*

There are 8 selenium locators to locate an element.

id -> The first 3 are called ATTRIBUTE
name
className
tagName
linkText
partialLinkText
xpath ->  There are multiple ways to write xpath
css   ->  There are multiple ways to write css
     */


    }

    // close the driver
    @After
    public void tearDown(){
        driver.quit();
    }

}
