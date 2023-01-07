package homework.thirdHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.*;

public class Synchronization1 extends TestBase {
    /*
Create a class:Synchronization2.
Create a method: synchronization2
Go to https://the-internet.herokuapp.com/dynamic_loading/2
When user clicks on the Start button
Then verify the ‘Hello World!’ Shows up on the screen
     */
    @Test
    public void synchronizationTest(){
        // Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        // user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebElement startButton = waitForClickability(driver.findElement(By.xpath("//div[@id='finish']//h4")), 10);

        assertEquals("Hello World!",startButton.getText());

    }

    @Test    // Mr Ahmet's solution
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//button")).click();
        WebElement helloWord=driver.findElement(By.xpath("//h4[.='Hello World!']"));
        assertEquals(helloWord.getText(),"Hello World!");
        //All is good. We don't need to use explicit wait. //Implicit wait solved the issue
        //Cause the element is not hidden(No display:none on Hello World).
        //The entire element <h4>Hello World!</h4> just renders late

    }

    @Test
    public void Synchronization2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
//User clicks on the Start button
        driver.findElement(By.xpath("//*[@id='start']/button")).click();

//Using ExplicitWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorld= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

//Then verify the 'Hello World!' Shows up on the screen
        assertTrue(helloWorld.isDisplayed());
    }

    @Test
    public void synchronization2(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        // When user clicks on the Start button
        driver.findElement(By.xpath("//*[@id='start']/button")).click();

        //Then verify the 'Hello World!' Shows up on the screen
        WebElement helloWorldText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        //use reusable method
        waitForVisibility(helloWorldText, 10);

        assertTrue(helloWorldText.isDisplayed());
    }
}
