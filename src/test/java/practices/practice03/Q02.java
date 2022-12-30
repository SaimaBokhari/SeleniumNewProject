package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q02 extends TestBase {
    /*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Click "Choose File" button
    And
        Select the file to upload
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
     */
    @Test
    public void test(){
        //  Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        // Type "My File" into "Notes about the file" input
        driver.findElement(By.name("note")).sendKeys("My File");

        // Click "Choose File" button and  Select the file to upload
        // We can send the path of the file directly, no need to "choose file" button
        //driver.findElement(By.name("upfile")).sendKeys("/Users/Ahmed/Desktop/text.txt"); This is not a dynamic way

        String userHome = System.getProperty("user.home");
        driver.findElement(By.name("upfile")).sendKeys(userHome+"/Desktop/text.txt"); // This is  a dynamic way

        // Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that "Your notes on the file were" equals "My File"
        String note = driver.findElement(By.xpath("//blockquote")).getText();
        assertEquals("My File", note);

        // Assert that file Content contains "Hello, I am uploaded file"
        String fileContent = driver.findElement(By.xpath("//pre")).getText();
        assertTrue(fileContent.contains("Hello, I am uploaded file"));


    }

}
