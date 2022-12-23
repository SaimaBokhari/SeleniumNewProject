package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */
    @Test
    public void emojiTest(){
       // Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

       // Click on the "Animals and Nature" emoji
        // but there's an iframe , we need to switch to that first
        WebElement iFrame = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iFrame);

        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

       // Click all the "Animals and Nature"  emoji elements
        List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

//        for (WebElement w : emojiList){
//            w.click();
//        }

        // Using Lambda is recommended
        // emojiList.stream().forEach(t-> t.click());
        // method reference  (the simplified version by intelliJ) is following
        emojiList.forEach(WebElement::click);

        // switch back from iframe first because the form is not inside the iframe
        driver.switchTo().defaultContent();
        // or    driver.switchTo().parentFrame();

        // Fill the form
        List<WebElement> formInputs = driver.findElements(By.xpath("//input"));
        List<String> allWords = new ArrayList<>(Arrays.asList("This","iFrame","example","looks","very","funny.", "Does","not","it","?","?"));
        for (int i=0; i<formInputs.size(); i++){
            formInputs.get(i).sendKeys(allWords.get(i));
        }


       // Press the apply button
        driver.findElement(By.id("send")).click();

       // Verify "code" element is displayed
        WebElement code = driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());


    }
}
