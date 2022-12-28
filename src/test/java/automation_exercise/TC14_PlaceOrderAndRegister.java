package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class TC14_PlaceOrderAndRegister extends TestBase {
    /*
    Test Case 14: Place Order: Register while Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Congratulations! Your order has been confirmed!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */


    @Test
    public void automationExerciseTest() throws InterruptedException {
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertEquals("Automation Exercise",title);

        //4. Add products to cart

        // Step 1: Hover over first product and click 'Add to cart'
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@data-product-id = '1'])[1]"));
        Thread.sleep(2000);

        // Step 2: Create the actions object
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(2000);

        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //6. Verify that cart page is displayed
        String cartTitle = driver.getTitle();
        assertTrue(cartTitle.contains("Checkout"));

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.linkText("Register / Login")).click();

        //9. Fill all details in Signup and create account
//        Faker faker = new Faker();
//        Actions actions = new Actions(driver);
//        driver.findElement(By.name("name")).sendKeys(faker.name().fullName());
//        actions.sendKeys(Keys.TAB).
//                sendKeys(faker.internet().emailAddress()).
//                sendKeys(Keys.TAB).
//                sendKeys(Keys.ENTER).build().perform();
//
//        driver.findElement(By.id("id_gender1")).click();
//        driver.findElement(By.id("password")).sendKeys(faker.internet().password()+Keys.TAB);
//        actions.sendKeys("10"+Keys.TAB).
//                sendKeys("April"+Keys.TAB).
//                sendKeys("2000"+Keys.TAB).
//                sendKeys(Keys.TAB).
//                sendKeys(Keys.TAB).
//                sendKeys(faker.name().firstName()+Keys.TAB).
//                sendKeys(faker.name().lastName()+Keys.TAB).
//                sendKeys(faker.company().name()+Keys.TAB).
//                sendKeys(faker.address().streetAddress()+Keys.TAB).
//                sendKeys(faker.address().streetAddressNumber()+Keys.TAB).
//                sendKeys(faker.address().country()+Keys.TAB).
//                sendKeys(faker.address().state()+Keys.TAB).
//                sendKeys(faker.address().city()+Keys.TAB).
//                sendKeys(faker.address().zipCode()+Keys.TAB).
//                sendKeys(faker.phoneNumber().phoneNumber()+Keys.TAB).
//                sendKeys(Keys.ENTER).build().perform();
//
//        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//        String accountVerify = driver.findElement(By.xpath("//b")).getText();
//        assertEquals("ACCOUNT CREATED!",accountVerify);
//
//        //11. Verify ' Logged in as username' at top
//        driver.findElement(By.linkText("Continue")).click();
//
//        //12.Click 'Cart' button
//        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
//
//        //13. Click 'Proceed To Checkout' button
//        driver.findElement(By.linkText("Proceed To Checkout")).click();
//
//        //14. Verify Address Details and Review Your Order
//        String addressDetail = driver.findElement(By.xpath("//*[text()='Address Details']")).getText();
//        assertTrue(addressDetail.contains("Address Details"));
//        String reviewOrder = driver.findElement(By.xpath("//*[text()='Review Your Order']")).getText();
//        assertTrue(reviewOrder.contains("Review Your Order"));
//
//        //15. Enter description in comment text area and click 'Place Order'
//        driver.findElement(By.name("message")).sendKeys("i got it! Man'");
//        driver.findElement(By.linkText("Place Order")).click();
//
//        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//        driver.findElement(By.name("name_on_card")).sendKeys(faker.name().fullName()+Keys.TAB);
//        actions.sendKeys(faker.finance().creditCard()+Keys.TAB).
//                sendKeys(faker.number().digits(3)+Keys.TAB).
//                sendKeys(String.valueOf(faker.number().numberBetween(01,12))+Keys.TAB).
//                sendKeys(String.valueOf(faker.number().numberBetween(2022,2028))+Keys.TAB).
//                build().perform();
//
//        //17. Click 'Pay and Confirm Order' button
//        driver.findElement(By.id("submit")).click();
//
//        //18. Verify success message 'Congratulations! Your order has been confirmed!'
//        String congrat = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).getText();
//
//        //19. Click 'Delete Account' button
//        driver.findElement(By.linkText(" Delete Account")).click();
//
//        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        String accountDeleted = driver.findElement(By.xpath("//*[@data-qa='account-deleted']")).getText();
//        assertTrue(accountDeleted.contains("ACCOUNT DELETED!"));


    }
}
