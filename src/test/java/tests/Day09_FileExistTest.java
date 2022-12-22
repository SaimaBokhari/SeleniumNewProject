package tests;

import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest  {

    @Test
    public void isExistTest(){
        /*
    Given
        Create a file on desktop
    When
        Copy the path of file
    Then
        Assert if the file exists
    */

        String userDIR = System.getProperty("user.dir");       // gives the path of the current folder .. dir stands for directory
        System.out.println("userDIR = " + userDIR);  // /Users/Ahmed/IdeaProjects/SeleniumNewProject

        String userHOME = System.getProperty("user.home");      // gives the path of the user's home (computer) dynamically
        System.out.println("userHOME = " + userHOME); // /Users/Ahmed

        // Verify if the file exists
        String pathOfFile = userHOME + "/Desktop/logo.jpeg";   // Writing the path dynamically so it can work on other computers as well
        boolean isExist = Files.exists(Paths.get(pathOfFile));   // returns true if file exists; false if it doesn't exist
        assertTrue(isExist);

    }
}
