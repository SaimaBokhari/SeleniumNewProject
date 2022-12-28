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

    @Test
    public void test(){
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Match the capitals by country
        // Locate the source and target
        // Capitals
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        // Countries
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement usa = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement korea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));

        // drag and drop

        Actions actions = new Actions(driver);
//        actions.dragAndDrop(oslo,norway).
//                dragAndDrop(stockholm,sweden).
//                dragAndDrop(washington,usa).
//                dragAndDrop(copenhagen,denmark).
//                dragAndDrop(seoul,korea).
//                dragAndDrop(rome,italy).
//                dragAndDrop(madrid,spain).
//                build().
//                perform();


        //id's have rules, so can be done by using them
        for(int i=1;i<8;i++){
            String sourceBox="box"+i;
            String destinationBox="box10"+i;
            WebElement source=driver.findElement(By.id(sourceBox));
            WebElement destination=driver.findElement(By.id(destinationBox));
            actions.dragAndDrop(source,destination).perform();
        }





    }

}
