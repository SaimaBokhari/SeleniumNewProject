package homework.thirdHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Synchronization3 extends TestBase {
    /*
Create a class:Synchronization4. Create a method: isEnabled
Go to https://the-internet.herokuapp.com/dynamic_controls
Click enable Button
And verify the message is equal to “It's enabled!”
And verify the textbox is enabled (I can type in the box)
And click on Disable button
And verify the message is equal to “It's disabled!”
And verify the textbox is disabled (I cannot type in the box)
NOTE: .isEnabled(); is used to check if an element is enabled or not
     */
    @Test
    public void synchronizationTest(){
        // Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Click enable Button
        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();

        WebElement enableButton = waitForClickability(driver.findElement(By.id("loading")), 10);

        // And verify the message is equal to “It's enabled!”
        assertTrue(driver.findElement(By.id("message")).getText().contains("It's enabled!"));

       //verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        assertTrue(textBox.isEnabled());

        // And click on Disable button
        button.click();
        WebElement disableButton = waitForClickability(driver.findElement(By.id("loading")), 10);

        //And verify the message is equal to “It's disabled!”
        assertTrue(driver.findElement(By.id("message")).getText().contains("It's disabled!"));

        //And verify the textbox is disabled (I cannot type in the box)
        assertFalse(textBox.isEnabled());


    }

    @Test
    public void isEnabledTest(){
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        //Verify the message is equal to "It's enabled!"
        WebElement message1 = waitForVisibility(driver.findElement(By.id("message")), 5);
        assertEquals("It's enabled!", message1.getText());

        //Verify the textbox is enabled (I can type in the box)
        assertTrue(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

        //Click on Disable button
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        //verify the message is equal to "It's disabled!"
        WebElement message2 = waitForVisibility(driver.findElement(By.id("message")), 5);
        assertEquals("It's disabled!", message2.getText());

        //And verify the textbox is disabled (I cannot type in the box)
        assertFalse(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

    }

    @Test
    public void Synchronization3(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //And verify the message is equal to "It's enabled!"
        WebElement itsEnabledText = driver.findElement(By.id("message"));
        waitForVisibility(itsEnabledText,15);

        assertTrue(itsEnabledText.isDisplayed());

        //And verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']//input"));
        assertTrue(textBox.isEnabled());


        //And click on Disable button
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        //And verify the message is equal to "It's disabled!"
        WebElement itsDisabledText = driver.findElement(By.id("message"));
        waitForVisibility(itsDisabledText,15);
        assertTrue(itsDisabledText.isDisplayed());


        //And verify the textbox is disabled (I cannot type in the box)
        WebElement textBox1 = driver.findElement(By.xpath("//form[@id='input-example']//input"));
        assertFalse(textBox1.isEnabled());
    }


}
