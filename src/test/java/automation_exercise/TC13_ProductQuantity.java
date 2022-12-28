package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC13_ProductQuantity extends TestBase {
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
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click 'View Product' for any product on home page
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@data-product-id = '1'])[1]"));
        Thread.sleep(2000);

        // Step 2: Create the actions object
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();

        //5. Verify product detail is opened


        //6. Increase quantity to 4
        String text = driver.findElement(By.xpath("//input[@type='number']")).getText();
        System.out.println("text = " + text);

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //9. Verify that product is displayed in cart page with exact quantity


    }
}
