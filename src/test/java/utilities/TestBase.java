package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public abstract class TestBase {
    protected static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    //    @After
    public void tearDown(){
        waitFor(3000);
        driver.quit();
    }

    // Auto Complete Reusable Method
    // This code is used for selecting and verifying our app auto complete search functionality
    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {

        // sending a KEYWORD Dynamically using first parameter
        driver.findElement(By.id("myCountry")).sendKeys(keyword);
        Thread.sleep(2000);
        // Selecting an option from the list Dynamically using SECOND parameter
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+textFromList+"']")).click();
        // Clicking on submit button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button']")).click();  // click on submit
        // Asserting if result contains the option that we selected Dynamically using SECOND parameter
        assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));

        // This reusable method is based for the given website... https://testcenter.techproeducation.com/index.php?page=autocomplete
        // You need to use the same LOGIC to create this reusable method for the company you work
        // Because your locators and xpath will be different
        // NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS, BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT
        // NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT
        // THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS

    }

    // Take a SCREENSHOT OF ENTIRE PAGE with this reusable method
    public void takeScreenShotOfPage() {
        // To create a screenshot, follow these steps
        // Step 1. Take screenshot using getScreenshotAs() method (This method comes from SELENIUM API). This takes THE SCREENSHOT of the entire page
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // this is the image object, not the name of the image

        // Step 2. Creating a path and a DYNAMIC NAME for the image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // getting the current local date and time

        // Path is where we save the screenshot.  user==> Project /dir ==> folder / Screenshots  ==> folder/  currentTime+".png ==> dynamic name of the image
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+".png";
        // System.out.println("path = " + path);
        // this is where we save the image, and every new screenshot will get a new name dynamically because
        // the seconds will be different everytime a new screenshot is taken

        // Step 3. Saving image in the path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Take a SCREENSHOT OF THE SPECIFIC ELEMENT with this reusable method
    public void takeScreenShotOfTheElement(WebElement webElement){
        // 1. Take screenshot
        File image = webElement.getScreenshotAs(OutputType.FILE);

        // 2. Creating a path and a DYNAMIC NAME for the image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // getting the current local date and time
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/Specific Elements/"+currentTime+".png";

        // 3. Saving image in the path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /* HARD WAIT
    @Param : second
     */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    JAVASCRIPT EXECUTOR
    @param WebElement
    Accepts a web element and scrolls into that element.
    We use normal methods first, if they don't work then we use JS.

    We may need to scroll in order to capture the screenshots properly for our reports
    We may need to scroll to specific elements with js executor because
    some elements may not load properly unless we scroll to them at the exact place
     */
    public void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /*
    scroll the page all the down
     */
    public void scrollAllDownByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    /*
    scroll the page all the way up
     */
    public void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    /*
    click on an element by JS
    @param WebElement
    Normally we use element.click() in selenium
    When there is an issue with click() (some advanced codes used, hidden, different UI etc.)
    Then we can use javascript click
     */

    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }

    /*
    @param : WebElement, String
    Types the string in the WebElement

    Normally we use element.sendKeys("text") to type in an input.
    ALTERNATIVELY we can use js executor to type in an input
    arguments[0].setAttribute('value','admin123');  -> SAME AS sending password value to password box => element.sendKeys("admin123")

    INTERVIEW QUESTION : What are the selenium methods that you use to type in an input?
    - sendKeys()
    - with javascript executor we can change the value of the input

     */
    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }

    /*
    param : id of the element
     */

    public void getValueByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);

//        How you get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get teh value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return teh text in an input
//        getText() returns the normal text on the webpage, but the default value in any input isn't normal text
//          e.g. the default value on a hotel checkin date.


    }

    //    Changes the changeBackgroundColorByJS of an element.
    //    Params: WebElement element, String color. NOT COMMON
    public void changeBackgroundColorByJS(WebElement element, String color){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }
    //    NOT COMMON
    public void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }


}
