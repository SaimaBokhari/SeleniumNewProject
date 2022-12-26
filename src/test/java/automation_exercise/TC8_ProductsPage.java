package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TC8_ProductsPage extends TestBase {
    /*
    Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail is visible: product name, category, price, availability, condition, brand

     */
    @Test
    public void productsPageTest() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        //String productsPageHeader = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        // The above doesn't work so I located the search box on this page
        assertTrue(driver.findElement(By.id("search_product")).isDisplayed());

        // 6. The products list is visible


        // 7. Click on 'View Product' of first product
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();


        // 8. User is landed to product detail page

        // 9. Verify that detail is visible: product name, category, price, availability, condition, brand
        assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[.='Category: Women > Tops']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[.='Rs. 500']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//b[.='Availability:']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//b[.='Condition:']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//b[.='Brand:']")).isDisplayed());



    }
}
