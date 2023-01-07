package homework.secondHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HW2_DatePicker extends TestBase {
    /*
When user goes to https://jqueryui.com/datepicker/
And select the next date of the current date
EG if today is August 30, 2022 -> select August 31, 2022
     */

    @Test
    public void test1() {

        // user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/ ");

        // switch to iframe first
        driver.switchTo().frame(0);

        // select the next date of the current date
        driver.findElement(By.id("datepicker")).click();

        List<WebElement> calender = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td[@data-handler='selectDay']"));

        String currentDate = new SimpleDateFormat("d").format(new Date());
        System.out.println(currentDate);


        for (int i = 0; i < calender.size(); i++) {

            if (calender.get(i).getText().equals(currentDate)) {

                calender.get(i + 1).click();
            }
        }

    }

    // Mr Ahmet Bayraam's solution
        @Test
        public void dateSelect1(){
            driver.get("https://jqueryui.com/datepicker/");
            driver.switchTo().frame(0);
            driver.findElement(By.id("datepicker")).sendKeys("09/10/2023");

        }

        // Mr Ahmet Bayraam's solution
        @Test
        public void dateSelect2(){
            driver.get("https://jqueryui.com/datepicker/");
            driver.switchTo().frame(0);
            driver.findElement(By.id("datepicker")).click();
            driver.findElement(By.xpath("//a[@data-date='10']")).click();

        }

    @Test
    public void test2(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        String currentDay= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        System.out.println("currentDay = " + currentDay);

        String[] todayArr = currentDay.split("/");

        int tomorrow = Integer.valueOf(todayArr[1])+1;
        System.out.println("tomorrow = " + tomorrow);
        String tomorrowDate= String.valueOf(tomorrow);
        driver.findElement(By.xpath("//a[@data-date='"+tomorrowDate+"']")).click();


    }

    @Test
    public void test3(){
        // When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");

        // Select the next date of the current date
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        List<WebElement> calender = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']"));
        System.out.println(calender.size());

        String currentDate = new SimpleDateFormat("d").format(new Date());
        System.out.println(currentDate);

        for(int i =0; i<calender.size();i++){
            if(calender.get(i).getText().equals(currentDate)){
                calender.get(i+1).click();
            }
        }

    }

    @Test
    public void test4(){

        driver.get("https://jqueryui.com/datepicker/ ");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        String today= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        String justDay = today.substring(3,5);
        String expectedDay = String.valueOf(Integer.valueOf(justDay)+ 1);

        driver.findElement(By.xpath("//a[@data-date='" + expectedDay + "']")).click();

    }
}
