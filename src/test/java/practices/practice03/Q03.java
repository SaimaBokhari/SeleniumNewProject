package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {
    /*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
      */
    @Test
    public void test(){

        // Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Click on the "Add Element" button 100 times
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i=0; i<100; i++){
            addButton.click();
        }

        // findElement() throws exception if the element is not available
        // findElements() returns empty list if there are no elements


        // Click on the "Delete" button 20 times
        List<WebElement> deleteButton = driver.findElements(By.xpath("//div[@id='elements']/button"));  // OR // button[@class='added-manually']
        System.out.println("Number of delete buttons BEFORE delete: " + deleteButton.size());

        for (int i=0; i<20; i++){
            deleteButton.get(i).click();
        }

        // Assert that 20 buttons were deleted
        // this is the list after deleting 20 times
        List<WebElement> deleteButtonAfterDelete = driver.findElements(By.xpath("//div[@id='elements']/button"));  // OR // button[@class='added-manually']
        System.out.println("Number of delete buttons AFTER delete: " + deleteButtonAfterDelete.size());

        assertEquals(80, deleteButtonAfterDelete.size());
        // OR
        assertEquals(deleteButton.size()-20, deleteButtonAfterDelete.size());



    }
}
