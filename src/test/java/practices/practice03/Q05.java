package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Q05 extends TestBase {
    /*
   Given
       Go to http://webdriveruniversity.com/To-Do-List/index.html
   When
       Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
   And
       Strike through all todos.
   And
       Delete all todos.
   Then
       Assert that all todos deleted.
    */
    @Test
    public void test() throws InterruptedException {
        // Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> todosList = new ArrayList<>(Arrays.asList("Prepare breakfast"," Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        // Locate the place to add todos

        WebElement inputTodos = driver.findElement(By.xpath("//input[@type='text']"));
        for (String w : todosList){
            inputTodos.sendKeys(w, Keys.ENTER);
        }

        // OR
        Actions actions = new Actions(driver);
        for (String w : todosList){
            actions.click(inputTodos).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }
        /*
        System.out.println("Add ToDos = " + addTodos.size());

for(int i=0 ; i< addTodos.size() ; i++ ){
    input.sendKeys(addTodos.get(i),Keys.ENTER);

}
         */


        // Strike through all todos.
        List<WebElement> allTodos   = driver.findElements(By.xpath("//li"));
        for (WebElement w : allTodos){
            w.click();
        }

        // Delete all todos.
        List<WebElement> deleteButtons   = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));

        for (WebElement w : deleteButtons){
            w.click();
        }
        Thread.sleep(2000);

        // Assert that all todos deleted.
        List<WebElement> allTodosAfterDelete   = driver.findElements(By.xpath("//li"));

        assertEquals(0, allTodosAfterDelete.size());

        // OR
        assertTrue(allTodosAfterDelete.isEmpty());

    }

}
