package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.*;

public class TC1_RegisterUser extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */
    @Test
    public void registerUser() throws InterruptedException {
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        // 5. Verify 'New User Signup!' is visible
        boolean signUp = driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        assertTrue(signUp);

        // 6. Enter name and email address
        driver.findElement(By.name("name")).sendKeys("Sadaf");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("sadaf@hotmail.com");

        Thread.sleep(2000);
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean form = driver.findElement(By.xpath("//h2")).isDisplayed();
        assertTrue(form);

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title = driver.findElement(By.id("id_gender2"));
        title.click();

        driver.findElement(By.id("password")).sendKeys("4567");

        // for date of birth
        WebElement dropdown1 = driver.findElement(By.id("days"));
        Select select1 = new Select(dropdown1);
        select1.selectByIndex(12);

        WebElement dropdown2 = driver.findElement(By.id("months"));
        Select select2 = new Select(dropdown2);
        select1.selectByIndex(1);

        WebElement dropdown3 = driver.findElement(By.id("years"));
        Select select3 = new Select(dropdown3);
        select1.selectByIndex(6);

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).isSelected();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).isSelected();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Sadaf");
        driver.findElement(By.id("last_name")).sendKeys("Ahmed");
        driver.findElement(By.id("company")).sendKeys("Oracle");
        driver.findElement(By.id("address1")).sendKeys("Thames Valley");
        driver.findElement(By.id("address2")).sendKeys("Reading");


        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select select = new Select(countryDropdown);
        select.selectByIndex(6);

        driver.findElement(By.id("state")).sendKeys("Southern");
        driver.findElement(By.id("city")).sendKeys("Reading");
        driver.findElement(By.id("zipcode")).sendKeys("RK17 98L");
        driver.findElement(By.id("mobile_number")).sendKeys("4478923673");

        Thread.sleep(2000);

        // 13. Click 'Create Account' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();


        Thread.sleep(2000);

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        String accountText = driver.findElement(By.xpath("(//b)[1]")).getText();
        assertEquals("ACCOUNT CREATED!", accountText);

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("(//a[@href='/'])[3]")).click();

        // 16. Verify that 'Logged in as username' is visible
        boolean isDisplayed = driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed();
        assertTrue(isDisplayed);

        // 17. Click 'Delete Account' button
//        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
//        Thread.sleep(2000);
//
//        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//        boolean accountDeleted = driver.findElement(By.xpath("(//b)[1]")).isDisplayed();
//        assertTrue(accountDeleted);
//
//        driver.findElement(By.xpath("(//a[@href='/'])[3]")).click();
//
//        Thread.sleep(2000);

    }
}
