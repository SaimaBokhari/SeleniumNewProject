package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileDownloadTest extends TestBase {
    /*
Given
    Go to "https://testcenter.techproeducation.com/index.php?page=file-download"
When
    Download b10 all test cases, code.docx file
    OR
    Download junit-4.13-beta-3.jar file
Then
    Verify if the file downloaded successfully
     */

    @Test
    public void fileDownloadTest(){
        //  Go to "https://testcenter.techproeducation.com/index.php?page=file-download"

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //  Download b10 all test cases, code.docx file
        driver.findElement(By.partialLinkText("code.docx")).click();

        // Verify if the file downloaded successfully
        String userHOME = System.getProperty("user.home");      // gives user home directory
        System.out.println("userHOME = " + userHOME);   // /Users/Ahmed

        boolean isDownloaded = Files.exists(Paths.get(userHOME + "/Downloads/b10 all test cases, code.docx"));
        assertTrue(isDownloaded);

        boolean isJarDownloaded = Files.exists(Paths.get(userHOME + "/Downloads/junit-4.13-beta-3.jar"));
        assertTrue(isJarDownloaded);



    }

}