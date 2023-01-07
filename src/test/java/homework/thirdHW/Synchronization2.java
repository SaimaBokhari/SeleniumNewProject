package homework.thirdHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Synchronization2 extends TestBase {
    /*
Create a class:Synchronization3. Create a method: synchronization1
Go to https://the-internet.herokuapp.com/dynamic_controls
Click on remove button
And verify the message is equal to “It's gone!”
Then click on Add button
And verify the message is equal to “It's back!”
     */
    @Test
    public void synchronizationTest(){
        // Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Click on button
        WebElement button = driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]"));
        button.click();

        WebElement removeButton = waitForClickability(driver.findElement(By.id("loading")), 10);

        // And verify the message is equal to “It's gone!”
        assertTrue(driver.findElement(By.id("message")).getText().contains("It's gone!"));

        //Then click on Add button
        button.click();
        WebElement addButton = waitForClickability(driver.findElement(By.id("loading")), 10);

        //And verify the message is equal to “It's back!”
        assertTrue(driver.findElement(By.id("message")).getText().contains("It's back!"));

    }
    @Test  // Mr Ahmet's Solution
    public void test1(){
//     No need to use explicit wait, implicit wait is enough
//        This is test case is done using implicit wait

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])"));
        removeButton.click();
//        And verify the message is equal to “It's gone!”
//      This is where I need to wait
//      What is our expected condition???
//      Expected condition is to wait for the It's gone element
        assertEquals("It's gone!",driver.findElement(By.xpath("//p[@id='message']")).getText());
        WebElement addButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        addButton.click();
        assertEquals("It's back!",driver.findElement(By.xpath("//p[@id='message']")).getText());

    }
    @Test  // Mr Ahmet's Solution
    public void test2(){
//     No need to use explicit wait, implicit wait is enough
//     But as example  This is test case is done using explicit wait
//     CREATE WAIT OBJECT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])"));
        removeButton.click();
//        And verify the message is equal to “It's gone!”
        //This is where I need to wait
        //What is our expected condition???
        //Expected condition is to wait for the It's gone element
        WebElement goneMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        WebElement goneMessage=driver.findElement(By.xpath("//p[@id='message']"));
        String goneMessageText=goneMessage.getText();
        assertEquals(goneMessageText,"It's gone!");
//        Then click on Add button
        WebElement addButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        addButton.click();

//        And verify the message is equal to “It's back!”
        WebElement backMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        WebElement backMessage=driver.findElement(By.xpath("//p[@id='message']"));
        String backMessageText=backMessage.getText();
        assertEquals(backMessageText,"It's back!");


    }

    @Test
    public void synchronization(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //  Click on remove button
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        //And verify the message is equal to "It's gone!"
        WebElement itsGoneText = driver.findElement(By.id("message"));
        waitForVisibility(itsGoneText,10);
        assertTrue(itsGoneText.isDisplayed());

        //Then click on Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();


        //And verify the message is equal to "It's back!"
        WebElement itsBackText = driver.findElement(By.id("message"));
        waitForVisibility(itsBackText,10);

        assertTrue(itsBackText.isDisplayed());
    }


}
