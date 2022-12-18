package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day05_DropDown {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // User goes to the given browser
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


    }

    @Test
    public void selectByIndexTest(){
        //1.Create method selectByIndexTest and Select Option 1 using index

        // Step 1:
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        //Step 2: Create 'Select' object
        Select select = new Select(dropDown);

        // Step 3: Select option by index/value/visible text
        select.selectByIndex(1);

    }

    @Test
    public void selectByVisibleTextTest(){
        //2.Create method selectByValueTest Select Option 2 by visible text

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Option 2");

    }

    @Test
    public void selectByValueTest() throws InterruptedException {
        //3.Create method selectByValueTest Select Option 1 value by value

       WebElement dropDown =  driver.findElement(By.id("dropdown"));
       Select select = new Select(dropDown);
       Thread.sleep(1000);  // Java wait

       select.selectByValue("1");
        Thread.sleep(1000);  // Java wait
       select.selectByValue("2");
        Thread.sleep(1000);  // Java wait
       select.selectByValue("1");
        Thread.sleep(1000);  // Java wait
       select.selectByValue("2");
    }

    @Test
    public void printAllTest(){
        //4.Create method printAllTest Print all dropdown value

        WebElement dropDown =  driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);

        // select.getOptions(); this returns a list of dropdown options so put it into a list container
        List<WebElement> allOptions = select.getOptions();

        // to get each element, we use for-each loop
        for (WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());  // getText() returns the TEXT of the webElements as String
        }

        //5. Verify the dropdown has Option 2 text
        boolean isOption2Exist = false;

        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals("Option 2")){
                isOption2Exist = true;
            }
        }
        // Test fails if "Option 2" is not in the dropdown; passes if it exists
        assertTrue(isOption2Exist);

    }

    @Test
    public void printFirstSelectedOptionTest(){
        //6.Create method printFirstSelectedOptionTest Print first selected option

        WebElement dropDown =  driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        // Printing the selected option
        System.out.println("Selected option is: " + select.getFirstSelectedOption().getText());

        // Selecting a different option and printing it
        select.selectByIndex(2);
        System.out.println("Selected option is: " + select.getFirstSelectedOption().getText());


        //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.


        // select.getOptions(); this returns a list of dropdown options so put it into a list container
        int numOfOptions = select.getOptions().size();
        int expectedNumOfOptions = 3;

        assertEquals("Expected Is Not Equal To Actual", expectedNumOfOptions, numOfOptions);

    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
/*
DropDown Interview Questions:
    - What is dropdown?
          Dropdown is a webElement. It has a list of options.
    - How do you handle dropdown? (What do you do to automate dropdown?)
          Dropdowns are created using SELECT class. We first locate the dropdown
          element, then use select class to interact with the dropdown elements.
    - How do you select dropdown elements?
          We actually have 3 ways to select a dropdown (by index, value, visibleText)

 */

// Test cases:
//Go to https://testcenter.techproeducation.com/index.php?page=dropdown
//1.Create method selectByIndexTest and Select Option 1 using index
//2.Create method selectByVisibleTextTest Select Option 2 by using visible text
//3.Create method selectByValueTest Select Option 1 value by value
//4.Create method printAllTest Print all dropdown value
//5. Verify the dropdown has Option 2 text
//6.Create method printFirstSelectedOptionTest Print first selected option
//7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.


/*
HW 1:

Create A Class: AmazonDropdown
Create A Method dropdownTest
Go to https://www.amazon.com/
Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
1. Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
2. Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
3. Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
4. Print the the total number of options in the dropdown
5. Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option. Print false otherwise.

BONUS: Assert if the dropdown is in Alphabetical Order

HW 2:
Create a new class : GoogleSearchTest.
Create main method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google

HW 3:


 */