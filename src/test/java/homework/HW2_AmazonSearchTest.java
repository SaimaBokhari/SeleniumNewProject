package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class HW2_AmazonSearchTest extends TestBase {
    //Create a new class: AmazonSearch
    // TC01_As user I want to know how many item are there on amazon in the first page after
    // I search "porcelain teapot"?
    // TC02_ Order the tea pot prices, find the min, max, and average price to the nearest cent.

    @Test
    public void amazonSearch() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot");
        driver.findElement(By.id("nav-search-submit-button")).click();


        String result=driver.findElement(By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println("First Page Item Count :" + result);

        WebElement orderCombo=driver.findElement(By.id("s-result-sort-select"));
        Select select = new Select(orderCombo);
        select.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // With this code, it waits until pagination elements get visible.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s-pagination-strip']")));

        List<WebElement> prices=driver.findElements(By.xpath("//span[@class='a-offscreen']"));  // normally it should return around 60 elements

        prices.stream().forEach(item-> System.out.println(item.getText()));
        //Min Price
        Double minPrice=0.0;
        for(WebElement item:prices) {
            String price=item.getAttribute("innerHTML").replaceAll("[^0-9.]","");
            if(price.length()>0) {
                minPrice=Double.valueOf(price);
                break;
            }
        }
        System.out.println("Min Price : " + minPrice);

        Thread.sleep(3000);

        /*
        Second Problem was prices were in a span tag and could not get them with getText() method.
Instead I got them by using getAttribute("innerHTML") method
         */

    }
}
