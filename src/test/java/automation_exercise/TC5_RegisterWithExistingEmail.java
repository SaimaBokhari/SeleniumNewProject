package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC5_RegisterWithExistingEmail extends TestBase {
    /*
    Test case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */
    @Test
    public void registerWithExistingEmailTest() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'New User Signup!' is visible
        boolean signUp = driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        assertTrue(signUp);

        // 6. Enter name and already registered email address
        driver.findElement(By.name("name")).sendKeys("Sadaf");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("sadaf@hotmail.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        // 8. Verify error 'Email Address already exist!' is visible
        assertTrue(driver.findElement(By.xpath("//p[.='Email Address already exist!']")).getText().contains("Email Address already exist!"));



    }
}
