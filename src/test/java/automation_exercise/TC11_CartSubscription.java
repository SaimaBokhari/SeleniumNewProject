package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC11_CartSubscription extends TestBase {
    /*
    Test Case 11: Verify Subscription in Cart page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible

     */
    @Test
    public void cartSubscriptionTest() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        // 5. Scroll down to footer
//        Actions actions = new Actions(driver);
//
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//
//        // 6. Verify text 'SUBSCRIPTION'
//        String subscriptionText = driver.findElement(By.xpath("//h2")).getText();
//        System.out.println("subscriptionText = " + subscriptionText);
//        assertTrue(subscriptionText.contains("SUBSCRIPTION"));
//
//        // 7. Enter email address in input and click arrow button
//        driver.findElement(By.id("susbscribe_email")).sendKeys("jack.jill@gmail.com");
//        driver.findElement(By.id("subscribe")).click();
//
//        // 8. Verify success message 'You have been successfully subscribed!' is visible
//        // the message disappears!!!!!!



    }
}
