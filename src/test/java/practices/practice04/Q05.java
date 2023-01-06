package practices.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q05 extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    When
        Fill the username, password and textArea comment:
    And
        Choose a file and upload it
    And
        Select all checkboxes, radio item 1 and dropdown 1
    And
        Click on submit
   Then
        Verify that uploaded file name is on the Form Details
     */

    @Test
    public void test(){
        //  Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //  Fill the username, password and textArea comment:
        driver.findElement(By.name("username")).sendKeys("John");
        driver.findElement(By.name("password")).sendKeys("12345");
        WebElement commentArea = driver.findElement(By.name("comments"));
        commentArea.clear();
        commentArea.sendKeys("Hello");

        //  Choose a file and upload it
        // Path of the file to be uploaded ==> /Users/Ahmed/Desktop/logo.jpeg
        driver.findElement(By.name("filename")).sendKeys(System.getProperty("user.home") + "/Desktop/logo.jpeg");  // dynamic way

        //  Select all checkboxes, radio item 1 and dropdown 1
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@value='cb3']"));

        // checkboxes
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
        if(!checkBox3.isSelected()){
            checkBox3.click();
        }

        //radio item 1
        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        //dropdown 1
        driver.findElement(By.xpath("//option[@value='ms1']")).click();

        // Click on submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Verify that uploaded file name is on the Form Details
        String fileName = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("logo.jpeg",fileName);

    }
}
