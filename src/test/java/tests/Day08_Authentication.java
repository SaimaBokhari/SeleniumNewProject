package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day08_Authentication extends TestBase {

    /*
        username : admin
        pass     : admin
        url      : the-internet.herokuapp.com/basic_auth
        SPECIAL URL FOR AUTHENTICATION:
        GO LINK  : https://username:pass@url

         */
    @Test
    public void authTest(){
        // Basic Authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Assertion
        String successMessage = driver.findElement(By.xpath("//p")).getText();
        assertEquals("Congratulations! You must have the proper credentials.", successMessage);

        // OR
       // assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());



    }
}
