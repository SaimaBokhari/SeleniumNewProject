package homework.firstHW;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HW1_AmazonDropdown {
    /*
    HW 1:

Create A Class: AmazonDropdown
Create A Method dropdownTest
Go to https://www.amazon.com/
Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
1. Print the first selected option and assert if it equals “All Departments”.
    If it fails, then comment that code out and continue rest of the test case.
2. Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
   (after you select you need to use get first selected option method). If it fails, then
    comment that code out and continue rest of the test case.
3. Print all of the dropdown options-getOptions(); method returns the List<WebElement>.
   Using loop, print all options.
4. Print the total number of options in the dropdown
5. Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option.
   Print false otherwise.

BONUS: Assert if the dropdown is in Alphabetical Order
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void dropdownTest(){
        // Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

        // 1. Print the first selected option and assert if it equals “All Departments”.
        // If it fails, then comment that code out and continue rest of the test case.
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        if (firstSelectedOption.equals("All Departments")){
            System.out.println("The first selected options is: All Departments");
        }else{
            System.out.println("The first selected options is not All Departments");
        }

        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        //   (after you select you need to use get first selected option method). If it fails, then
        //    comment that code out and continue rest of the test case.

        select.selectByIndex(3);
        String expectedDropdown = select.getFirstSelectedOption().getText();
        String actualDropdown = "Amazon Devices";
        // assertEquals("expectedDropdown is not here", expectedDropdown,actualDropdown);


        // 3. Print all of the dropdown options-getOptions(); method returns the List<WebElement>.
        //   Using loop, print all options.
        List<WebElement> listOfOptions =select.getOptions();
        for (WebElement w: listOfOptions){
            System.out.println(w.getText());
        }

        // Print the total number of options in the dropdown
        int numOfOptions = listOfOptions.size();
        System.out.println("numOfOptions = " + numOfOptions);

        // 5. Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option.
        //   Print false otherwise.

        boolean flag = false;
        for (WebElement w: listOfOptions){
            if (w.getText().equals("Appliances")){
                flag = true;
            }
        }
        System.out.println("Dropdown option has ‘Appliances’? " + flag);


        // BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> actualList = new ArrayList<>();
        for (WebElement w: listOfOptions){
            actualList.add(w.getText());
        }
        List<String> orderedList = new ArrayList<>(actualList);
        Collections.sort(orderedList);
        assertEquals(orderedList,actualList);

        // BONUS: Assert if the dropdown is in Alphabetical Order == lambda
//        List<String> sortedList = actualList.stream().sorted().collect(Collectors.toList());
//        System.out.println("sortedList = " + sortedList);
//        assertEquals("Dropdown is not in Alphabetical Order",actualList,sortedList);
    }
    @After
    public void tearDown(){
        driver.quit();
    }


}


