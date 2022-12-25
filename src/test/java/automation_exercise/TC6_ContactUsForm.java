package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC6_ContactUsForm extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */
    @Test
    public void contactUsFormTest(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        // 5. Verify 'GET IN TOUCH' is visible
        boolean visibleText = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed();
        assertTrue(visibleText);

        // 6. Enter name, email, subject and message
        driver.findElement(By.name("name")).sendKeys("Emily");
        driver.findElement(By.name("email")).sendKeys("emily.will@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("Complaint");
        driver.findElement(By.id("message")).sendKeys("You should use more ids for the webElements");

        // 7. Upload file
        // Step 1. Locate 'choose file' button and click
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));

        // Step 2. we need to find the path of the file to be uploaded
        //Select the file with its path from your computer
        String userHOME = System.getProperty("user.home");
        String pathOfFile = userHOME + "/Desktop/logo.jpeg";

        // Send the path of the file we want to upload, using sendkeys because the input type is 'file'
        chooseFileButton.sendKeys(pathOfFile);

        // 8. Click 'Submit' button
        driver.findElement(By.name("submit")).click();

       // 9. Click OK button
       // When we submit, an alert pops up. So we need to switch to alert first and then accept it
        driver.switchTo().alert().accept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        boolean alertMessage = driver.findElement(By.xpath("//div[.='Success! Your details have been submitted successfully.']")).isDisplayed();
        assertTrue(alertMessage);

        // 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//a[@href='/'])[2]")).click();
        boolean backToHomePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(backToHomePage);


    }
}
