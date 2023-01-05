package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {
    @Test
    public void timeOutTest(){
        driver.get("https://techproeducation.com/");
        // Trying to locate the element using Explicit Wait
        waitForVisibility(By.id("wrong-id"),10);  // TimeoutException

        // We get TimeOutException because explicit wait couldn't handle the issue
        // (couldn't locate the element despite waiting for 10 seconds)
        // wait time is over but the command is still not completed


    }
}
