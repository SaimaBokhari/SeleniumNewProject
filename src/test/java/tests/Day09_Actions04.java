package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day09_Actions04 extends TestBase {
    /*
        Given
                Go to "https://jqueryui.com/droppable/"
        When
                Drag the element "Drag me to my target" to "Drop here" element and drop it.

     */

    @Test
    public void dragAndDropTest(){

        driver.get("https://jqueryui.com/droppable/");

        // Step 1: Create actions object
        Actions actions = new Actions(driver);

        // Step 2: Locate the web elements (source and target)
        // there is an iframe , switch to that first
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Use Actions class to drag source into the target
        actions.dragAndDrop(source,target).perform();

    }
    /*
    In case of test failure:
    1. check locator
    2. wait issue / synchronisation issue
    3. iframe? ... this was the issue for this test case
     */

    @Test
    public void clickAndHoldTest() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");

        // Step 1: Create actions object
        Actions actions = new Actions(driver);

        // Step 2: Locate the element
        // there is an iframe , switch to that first
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Use Actions class to click and hold source and then drop into the target
        Thread.sleep(2000);
        actions.clickAndHold(source).moveToElement(target).build().perform();

    }

    @Test
    public void moveByOffsetTest() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");

        // Step 1: Create actions object
        Actions actions = new Actions(driver);

        // Step 2: Locate the element
        // there is an iframe , switch to that first
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Use Actions class to drag source into the target
        Thread.sleep(2000);
        actions.clickAndHold(source).moveByOffset(160,-30).build().perform(); // we use x and y-axis coordinate


    }

    @Test
    public void dragAndDropByTest() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");

        // Step 1: Create actions object
        Actions actions = new Actions(driver);

        // Step 2: Locate the element
        // there is an iframe , switch to that first
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Use Actions class to drag source into the target
        Thread.sleep(2000);
        actions.dragAndDropBy(source, 160,30).build().perform(); // we use x and y-axis coordinate

        Thread.sleep(2000);

    }
}
