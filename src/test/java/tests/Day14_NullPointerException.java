package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class Day14_NullPointerException {
    WebDriver driver;  // null
    Integer number;
    String str;

    @Test
    public void nullPointerExceptionTest(){
        // If a variable is created but not instantiated, when pointer doesn't show any value,
        // we get NullPointerException

            driver.get("https://techproeducation.com/");

            // Throws NullPointerException coz driver doesn't know which browser to open
            // chrome, or edge, or safari

     }


    @Test
    public void nullPointerExceptionTest1(){
        System.out.println(number+1);   // coz number in Integer (wrapper class, non-primitive and not instantiated)

    }

    @Test
    public void nullPointerExceptionTest2(){
        str.substring(0);

    }

}
