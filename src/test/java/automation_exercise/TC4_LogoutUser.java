package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC4_LogoutUser extends TestBase {
    /*
    TC4:
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */

    @Test
    public void logout(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        boolean logInText = driver.findElement(By.xpath("//h2")).isDisplayed();
        assertTrue(logInText);

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("sadaf@hotmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("4567");

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 8. Verify that 'Logged in as username' is visible
        boolean isDisplayed = driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed();
        assertTrue(isDisplayed);

        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        // 10. Verify that user is navigated to login page
        boolean backToHomePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(backToHomePage);



    }
}
