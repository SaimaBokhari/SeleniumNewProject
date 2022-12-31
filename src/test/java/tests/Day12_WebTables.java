package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day12_WebTables extends TestBase {
    @Test
    public void printTableData(){
        /*
https://the-internet.herokuapp.com/tables
Create a class: WebTables
Task 1 : Print the entire table
Task 2 : Print All Rows
Task 3 : Print Last row data only
Task 4 : Print column 5 data in the table body
Task 5 : Write a method that accepts 2 parameters
Parameter 1 = row number
Parameter 2 = column number
printData(2,3);  => prints data in 2nd row 3rd column

         */
        // Go to https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables ");

        // Task 1 : Print the entire table
        System.out.println("Print Entire Table *********");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("entireTable = " + entireTable);

        System.out.println("===========================");

        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement w : allTableElements){
            System.out.println(w.getText());
        }

        // We can get specific cell data
        System.out.println("============================");
        System.out.println("4th Data in the table: "+ allTableElements.get(4).getText());


    }
    @Test
    public void printRows(){
        // Go to https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables ");

        //Task 2 : Print All Rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRows = " + allRows);

        System.out.println("======================");
        // for all rows one by one
        for (WebElement w: allRows){
            System.out.println(w.getText());
        }

        System.out.println("========================");

        // make it more readable
        int rowNumb = 1;
        for (WebElement eachRow:allRows){
            System.out.println("Row "+rowNumb+" => "+eachRow.getText());
            rowNumb++;
        }

        // for specific rows
        System.out.println("4th Row Data: "+allRows.get(4).getText());

        System.out.println("============================");
        // Task 3 : Print Last row data only
        System.out.println("Last Row Data: "+allRows.get(allRows.size()-1).getText());
    }
    @Test
    public void printColumns(){
        // Go to https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables ");

        //Task 4 : Print column 5 data in the table body
        List<WebElement> col5Data = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNumb = 1;
        for (WebElement w : col5Data){
            System.out.println("Row "+colNumb+" Column 5 => " +w.getText());
            colNumb++;
        }
    }


}
