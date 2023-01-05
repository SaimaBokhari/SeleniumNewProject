package homework.secondHW;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class HW1 extends TestBase {
    /*
When user goes to https://jqueryui.com/accordion/
And user clicks on Section2 accordion
Verify the text contains “Sed non urna.”
     */

    @Test
    public void test(){
        // user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");

        // switch to iframe first
        driver.switchTo().frame(0);

        // user clicks on Section2 accordion
        driver.findElement(By.xpath("//*[@id='ui-id-3']")).click();

        waitFor(2);
        String text = driver.findElement(By.xpath("//*[@id='ui-id-4']//p")).getText();
        assertTrue(text.contains("Sed non urna."));



    }
}
