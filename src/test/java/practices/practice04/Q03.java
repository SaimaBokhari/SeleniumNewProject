package practices.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    When
        Click all the buttons
    Then
        Assert all buttons clicked
     */

// This question is on different types of clicks
    @Test
    public void test(){
        // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //        Click all the buttons
        // first button
        driver.findElement(By.id("onblur")).click();  // in the first click, it isn't working. "on blur" means it should loose focus.
        driver.findElement(By.id("onclick")).click(); // This click didn't trigger the 2nd button. It actually worked for the first button because the focus was not on the first button anymore

        // second button
        driver.findElement(By.id("onclick")).click(); // This will click on the actual 2nd button

        // third button .. clicks when we do right-click
        // We need to use Actions class
        WebElement thirdButton = driver.findElement(By.id("oncontextmenu"));
        WebElement fourthButton = driver.findElement(By.id("ondoubleclick"));
        WebElement fifthButton = driver.findElement(By.id("onfocus"));
        WebElement sixthButton = driver.findElement(By.id("onkeydown"));
        WebElement seventhButton = driver.findElement(By.id("onkeyup"));
        WebElement eigtthButton = driver.findElement(By.id("onkeypress"));
        WebElement ninthButton = driver.findElement(By.id("onmouseover"));
        WebElement tenthButton = driver.findElement(By.id("onmouseleave"));
        WebElement eleventhButton = driver.findElement(By.id("onmousedown"));


        Actions actions = new Actions(driver);
        // method chain
        actions.
                contextClick(thirdButton).
                doubleClick(fourthButton).
                click(fifthButton).
                click(sixthButton).sendKeys(Keys.ENTER).  // This button needs click and press any other key
                click(seventhButton).sendKeys(Keys.SPACE). // This button needs click and press any other key
                click(eigtthButton).sendKeys(Keys.ENTER).  // This button needs click and press any other key
                moveToElement(ninthButton).
                moveToElement(tenthButton).
                click(eleventhButton). // This click triggered 10th button
                click(eleventhButton).
                perform();


        //        Assert all buttons clicked

        List<WebElement> buttons  = driver.findElements(By.xpath("//p[.='Event Triggered']"));
        int numOfClickedButtons = buttons.size();
        assertEquals(11, numOfClickedButtons);

    }
}
