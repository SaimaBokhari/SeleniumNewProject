package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day10_FileUpload extends TestBase {
    /*
Class Name: FileUploadTest
Method Name: fileUploadTest
When user goes to https://the-internet.herokuapp.com/upload
When user selects an image from the desktop
And click on the upload button
Then verify the File Uploaded!  Message displayed
     */

    @Test
    public void fileUpload() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // 1. Locate 'choose file' button and click
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        Thread.sleep(2000);

        // When tagName is input, and type is 'file' like following
        // <input type='file'> is always used in html to upload files,
        // so we can use sendkeys to send the path of the file we want to upload


        // 2. Select the file with its path from your computer
        String userHOME = System.getProperty("user.home");      // gives the path of the user's home (computer) dynamically
        String pathOfFile = userHOME + "/Desktop/logo.jpeg";   // Writing the path dynamically, so it can work on other computers as well

        // logo.jpeg is the name of the file I uploaded. We only have to change the name of the file that we want to upload

        // Send the path of the file we want to upload, using sendkeys because the input type is 'file'
        chooseFileButton.sendKeys(pathOfFile);

        // 3. Then locate "upload' button click upload
        driver.findElement(By.id("file-submit")).click();


//        Verify the File Uploaded!  Message displayed
        boolean successMessage1 = driver.findElement(By.xpath("//h3")).isDisplayed();
        assertTrue(successMessage1);

        // OR

        boolean successMessage2 = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        assertTrue(successMessage2);

        /*
        INTERVIEW QUESTION
        How do you upload a file with selenium?
        - Selenium has limitations regarding automation of files. But files can be
           uploaded with selenium.

         - Locate the webElement 'choose file', use sendkeys function to send the
           path of the file. This will automatically upload the file.
         - Path of the file can be found by using System.getProperty("user.home") function dynamically.
         - Then locate and click the submit / upload button

LIMITATION:
Selenium has limitation of automating DESKTOP APP e.g. path of files or verify if file exists on our machine or not
We use JAVA-Selenium combination: we use Java to find the path of the files and verify with selenium

If there is input type= 'file' combination, I would first type the path of file dynamically and
with the help of sendKeys() I send the path of file and then locate and click the submit / upload button


         */

    }
}
