package homework.secondHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class HW3 extends TestBase {
    /*
    When user goes to https://jqueryui.com/toggle/
Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
Then click on Run Effect button
Then print the text and verify it is empty.
Eg: System.out.println(element); -> NO TEXT
Then click on Run Effect button one more time
Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
You can use hard wait if needed.
     */

    @Test
    public void test(){
        // user goes to https://jqueryui.com/toggle/
        driver.get("https://jqueryui.com/toggle/ ");

        // switch to iframe first
        driver.switchTo().frame(0);

        // Print the text that should be : Etiam libero neque, ......
        String text = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("text = " + text);

        //Then click on Run Effect button
        WebElement button = driver.findElement(By.id("button"));
        button.click();
        waitFor(2);

        //Then print the text and verify it is empty.
        String textAfterClick = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("textAfterClick = " + textAfterClick);

        assertTrue(textAfterClick.isEmpty());

        // Then click on Run Effect button one more time
        button.click();
        waitFor(2);

        //Print the text that should be : Etiam libero neque,......
        System.out.println("text = " + text);


    }
    @Test
    public void test1(){
        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//*[@id='effect']/p"));
        String toggleText = element.getText();
        System.out.println(toggleText);
        driver.findElement(By.id("button")).click();
        waitFor(2);
        String afterClick = element.getText();
        assertTrue(afterClick.isEmpty());

        driver.findElement(By.id("button")).click();
        waitFor(2);
        System.out.println(element.getText());
    }
}
