package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TC9_SearchProduct extends TestBase {
    /*
    Test Case 9: Search Product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
     */
    @Test
    public void searchProductTest(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        boolean homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(homePage);

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        assertTrue(driver.findElement(By.id("search_product")).isDisplayed());


        // 6. Enter product name in search input and click search button
        // locate searchbox
        WebElement searchBox = driver.findElement(By.id("search_product"));
        searchBox.sendKeys("Jeans");
        // locate clickable search button
         driver.findElement(By.xpath("//button[@id ='submit_search']")).click();

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        String successMessage = driver.findElement(By.xpath("//h2[.='Searched Products']")).getText();
        //System.out.println("successMessage = " + successMessage);
        assertTrue(successMessage.contains("SEARCHED PRODUCTS"));


        // 8. Verify all the products related to search are visible
        WebElement searchBox1 = driver.findElement(By.id("search_product"));
        searchBox.sendKeys("Jeans");

        // ?????????

    }
}
