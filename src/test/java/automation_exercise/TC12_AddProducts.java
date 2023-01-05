package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

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
    public void addProductsTest() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // an ad appears randomly; when inspected, it has an iframe so I switch to iframe and dismiss it
//        WebElement iFrame = driver.findElement(By.xpath("//div[@class='creative']/iframe[@id='ad_iframe']"));
//        driver.switchTo().frame(iFrame).close();
//  But it didn't work
//        // back to the main browser
//        driver.switchTo().defaultContent();

        // 5. Hover over first product and click 'Add to cart'
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@data-product-id = '1'])[1]"));
        Thread.sleep(2000);

        // Step 2: Create the actions object
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(2000);

        // 6. Click 'Continue Shopping' button ... can't locate the pop-up and therefore can't click on 'continue shopping'

        driver.findElement(By.xpath("//div[@class='modal-footer']//button[.='Continue Shopping']")).click();

        // 7. Hover over second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("(//a[@data-product-id = '2'])[1]"));

        actions.moveToElement(secondProduct).perform();
        Thread.sleep(2000);

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        // 9. Verify both products are added to Cart
        WebElement cart = driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));


        // 10. Verify their prices, quantity and total price
        // ???????


    }

        @Test
        public void addProductsTest1() throws InterruptedException {
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");

            // 3. Verify that home page is visible successfully
            //  ------------------------------------------------------------------------------------------------------
            //    NOTE (): IT SAYS TO VERIFY HOME PAGE IS VISIBLE OR NOT.
            //            THE logo.png IS BEING DISPALYED ALL PAGES SUCH AS HOME, PRODUCT, CART, ... ETC.
            //             SO IN MY OPONION, IT CAN BE VERIFY BY PAGE TITLE OR JUST 'Home' TEXT COLOR WHICH IS ORANGE
            boolean isHomePageDisplayed = driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed();   // OR //a[contains(@style,'orange')]
            assertTrue(isHomePageDisplayed);
            //    ------------------------------------------------------------------------------------------------------


            // 4. Click 'Products' button
            driver.findElement(By.xpath("//a[@href='/products']")).click();

            //------------------------------------------------------------------------------------------------------
            // NOTE : I THINK IT IS BECAUSE OF WEB DRIVER.
            //EVERY TIME DIFFERENT DIALOG APPEARS SO I COULD NOT CLOSE IT ALSO
            //BUT IF YOU CLOSE IT QUICKLY, TEST CONTINUES
            //------------------------------------------------------------------------------------------------------


            // 5. Hover over first product and click 'Add to cart'
            //  WE SHOULD LOCATE TO WRAPPER div
            WebElement firstProduct = driver.findElement(By.xpath("//div[@class='product-image-wrapper'][1]"));  // (//div[@class='product-image-wrapper'])[1]
            String firstProductPrice = driver.findElement(By.xpath("(//div[@class='productinfo text-center']//h2)[1]")).getText().replaceAll("[^0-9]", "");

            //OR
            //WebElement firstProductWrapperDiv = driver.findElements(By.xpath("//div[@class='product-image-wrapper']")).get(0);
            //------------------------------------------------------------------------------------------------------


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-image-wrapper'][1]")));


            // Step 2: Create the actions object
            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).perform();
            Thread.sleep(2000);

            //------------------------------------------------------------------------------------------------------
            // NOTE : NOW WE SHOULD LOCATE TO "Add to cart" AND CLICK IT
            driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
            //------------------------------------------------------------------------------------------------------

            // 6. Click 'Continue Shopping' button ... can't locate the pop-up and therefore can't click on 'continue shopping'
            //driver.findElement(By.xpath("//div[@class='modal-footer']//button[.='Continue Shopping']")).click();

            //------------------------------------------------------------------------------------------------------
            // NOTE : IT IS NOT JAVASCRIPT ALERT OR WINDOW. IT IS A MODAL DIALOG WHICH IS CREATED WITH HTML.
            //I MEAN IT IS A PART OF CURRENT HTML PAGE. SO JUST LOCATE IT'S BUTTON AND CLICK IT
            driver.findElement(By.xpath("//div[@class='modal-footer']//button")).click();
            //------------------------------------------------------------------------------------------------------


            // 7. Hover over second product and click 'Add to cart'

            WebElement secondProduct = driver.findElements(By.xpath("//div[@class='product-image-wrapper']")).get(1);
            String secondProductPrice = driver.findElement(By.xpath("(//div[@class='productinfo text-center']//h2)[2]")).getText().replaceAll("[^0-9]", "");
            //------------------------------------------------------------------------------------------------------
            actions.moveToElement(secondProduct).perform();
            Thread.sleep(2000);

            //------------------------------------------------------------------------------------------------------
            // CLICK THE SECOND PRODUCT "Add to cart"
            driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]")).click();
            //------------------------------------------------------------------------------------------------------


            // 8. Click 'View Cart' button
            // THERE IS A 'View Cart' BUTTON IN THE OPENED DIALOG. IT SHOULD BE CLICKED
            // AND IT SAYS Click 'View Cart' NOT 'Cart'
            driver.findElement(By.xpath("//div[@class='modal-body']//a")).click();
            //------------------------------------------------------------------------------------------------------

            Thread.sleep(2000);

            // 9. Verify both products are added to Cart
            // IF THEY ADDED TO CART, THERE SHOULD BE 2 TR(LINES) IN THE TABLE
            List<WebElement> addedProducts = driver.findElements(By.xpath("//table//tr[contains(@id,'product')]"));
            Assert.assertEquals(2, addedProducts.size());
            //------------------------------------------------------------------------------------------------------


            // 10. Verify their prices, quantity and total price
            //------------------------------------------------------------------------------------------------------
            //TO VERIFY, EXPECTED DATA SHOULD HAVE BEEN TAKEN DURING ADD PROCESS

            Integer productPrice1_InCart = Integer.valueOf(driver.findElement(By.xpath("//tr[@id='product-1']/td[3]/p")).getText().replaceAll("[^0-9]", ""));
            Integer productPrice2_InCart = Integer.valueOf(driver.findElement(By.xpath("//tr[@id='product-2']/td[3]/p")).getText().replaceAll("[^0-9]", ""));

            Integer productQuantity1_InCart = Integer.valueOf(driver.findElement(By.xpath("//tr[@id='product-1']/td[4]/button")).getText().replaceAll("[^0-9]", ""));
            Integer productQuantity2_InCart = Integer.valueOf(driver.findElement(By.xpath("//tr[@id='product-2']/td[4]/button")).getText().replaceAll("[^0-9]", ""));

            Integer productTotalPrice1_InCart = Integer.valueOf(driver.findElement(By.xpath("//*[@id='product-1']//p[@class='cart_total_price']")).getText().replaceAll("[^0-9]", ""));
            Integer productTotalPrice2_InCart = Integer.valueOf(driver.findElement(By.xpath("//*[@id='product-2']//p[@class='cart_total_price']")).getText().replaceAll("[^0-9]", ""));

            Integer expectedTotal1 = productPrice1_InCart * productQuantity1_InCart;
            Integer expectedTotal2 = productPrice2_InCart * productQuantity2_InCart;


            Assert.assertEquals(expectedTotal1, productTotalPrice1_InCart);
            Assert.assertEquals(expectedTotal2, productTotalPrice2_InCart);


    }
}
