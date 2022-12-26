package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC12_AddProducts extends TestBase {
    /*
    Test Case 12: Add Products in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
     */
    @Test
    public void addProductsTest(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Hover over first product and click 'Add to cart'
        // 6. Click 'Continue Shopping' button
        // 7. Hover over second product and click 'Add to cart'
        // 8. Click 'View Cart' button
        // 9. Verify both products are added to Cart
        // 10. Verify their prices, quantity and total price
    }
}
