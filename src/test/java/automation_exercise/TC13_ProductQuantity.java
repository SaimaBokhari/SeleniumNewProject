package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TC13_ProductQuantity extends TestBase {
    private WebDriver webDriver;

    /*
        Test Case 13: Verify Product quantity in Cart
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity
         */
    @Test
    public void productQuantityTest() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean isHomePageDisplayed = driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed();   // OR //a[contains(@style,'orange')]
        assertTrue(isHomePageDisplayed);

        // 4. Click 'View Product' for any product on home page
        //clickByJS(driver.findElement(By.xpath("//a[@href='/product_details/1']")));
        clickByJS(driver.findElement(By.linkText("View Product")));

        Thread.sleep(2000);


//        //5. Verify product detail is opened
        boolean reviews = driver.findElement(By.xpath("//a[@href='#reviews']")).isDisplayed();
        assertTrue(reviews);


//        //6. Increase quantity to 4
        //clickByJS(driver.findElement(By.xpath("//input[@type='number']")));
        getValueByJS("quantity");  // 1


//        //7. Click 'Add to cart' button
//        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
//
//        //8. Click 'View Cart' button
//        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
//
//        //9. Verify that product is displayed in cart page with exact quantity


    }

}

    
