package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day14_StaleElementException extends TestBase {

    @Test
    public void staleElementExceptionTest() {
        driver.get("https://techproeducation.com/");

        WebElement lms = driver.findElement(By.linkText("LMS LOGIN"));
        System.out.println(lms.getText());

        driver.navigate().refresh();
        System.out.println(lms.getText());  // StaleElementReferenceException

        // Note: After the refresh we should locate the element again
        // SOLUTION: RELOCATE THE ELEMENT
//
//        WebElement lms = driver.findElement(By.linkText("LMS LOGIN"));
//        System.out.println(lms.getText());

        /*
        Even if the elements are same, their references stored in HEAP memory are different.
        When we refresh the page, the reference for that webElement changes everytime.
        So we have to locate the element again otherwise we get StaleElementReferenceException

         */


    }
}
