package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {
    // Go to URL : https://demo.automationtesting.in/Static.html
    // Drag and drop elements.

    @Test
    public void dragAndDrop() throws InterruptedException {

        // Go to URL : https://demo.automationtesting.in/Static.html
        driver.get("https://demo.automationtesting.in/Static.html");

        // Drag and drop elements
        // Step 1:
        // First locate the elements (sources) that are supposed to be dragged
        WebElement firstObject = driver.findElement(By.id("angular"));
        WebElement secondObject = driver.findElement(By.id("mongo"));
        WebElement thirdObject = driver.findElement(By.id("node"));

        // Locate target
        WebElement target = driver.findElement(By.id("droparea"));

        // Step 2: Create actions object
        Actions actions = new Actions(driver);

        actions.dragAndDrop(firstObject,target).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(secondObject,target).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(thirdObject,target).perform();

        // method chain
//        actions.
//                dragAndDrop(firstObject, target).
//                dragAndDrop(secondObject, target).
//                dragAndDrop(thirdObject, target).
//                build().
//                perform();


    }

}
