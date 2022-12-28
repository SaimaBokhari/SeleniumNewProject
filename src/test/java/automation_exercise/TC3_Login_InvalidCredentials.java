package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.*;

public class TC3_Login_InvalidCredentials extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
    */
    @Test
    public void login(){
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
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("ali_haider@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        boolean failureMessage = driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).isDisplayed();
        assertTrue(failureMessage);

    }
}
