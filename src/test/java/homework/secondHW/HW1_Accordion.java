package homework.secondHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class HW1_Accordion extends TestBase {
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

        waitFor(2);  // Hard wait by REUSABLE METHOD
        String text = driver.findElement(By.xpath("//*[@id='ui-id-4']//p")).getText();
        assertTrue(text.contains("Sed non urna."));



    }

    // Mr Ahmet Bayraam's solution
    @Test
    public void accordion() throws InterruptedException {
        driver.get("https://jqueryui.com/accordion/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        We need to use Actions class to drag and drop


//        Elements are inside the iframe, so switch first
        driver.switchTo().frame(0);

        WebElement section2 = driver.findElement(By.id("ui-id-3"));


        Actions actions = new Actions(driver);
        actions.click(section2).perform();

//        Thread.sleep(1);
        String text = driver.findElement(By.xpath("//p[contains(text(),'Sed non urna.')]")).getText();
        System.out.println(text);
    }

}
