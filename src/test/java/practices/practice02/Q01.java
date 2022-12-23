package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {
    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */
    @Test
    public void formTest() throws InterruptedException {
        // Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

        // Fill the form
        driver.findElement(By.name("first_name")).sendKeys("Muhammad");
        driver.findElement(By.name("last_name")).sendKeys("Ahmed");
        driver.findElement(By.name("business_name")).sendKeys("QA");
        driver.findElement(By.name("email")).sendKeys("ma@gmail.com");

        // Click on 'SUBMIT'
        // We need to handle the addition operation first before we can submit
        int firstNumber = Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        // Integer firstNumber1 = Integer.valueOf(driver.findElement(By.id("numb1")).getText());
        int secondNumber = Integer.parseInt(driver.findElement(By.id("numb2")).getText());

        String result = firstNumber + secondNumber + "";

        driver.findElement(By.id("number")).sendKeys(result);

        // now submit
        driver.findElement(By.id("demo")).click();

        //OR
//        WebElement  submitButton = driver.findElement(By.id("demo"));
//        submitButton.sendKeys(Keys.ENTER);

        // We need to handle the alert as well
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Assert that the form has been sent
        WebElement successMessage = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        boolean isThankyou = successMessage.isDisplayed();
        assertTrue(isThankyou);

        //OR

        String successText =  successMessage.getText();
        assertTrue(successText.contains("Thank you"));


    }
}
