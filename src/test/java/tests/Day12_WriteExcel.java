package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day12_WriteExcel {
    /*
Create a new class: WriteExcel
Create a new method: writeExcel()
Store the path of the file as string and open the file
Open the workbook
Open the first worksheet
Go to the first row
Create a cell on the 3rd column (2nd index) on the first row
Write “POPULATION” on that cell
Create a cell on the 2nd row 3rd cell(index2), and write 150000
Create a cell on the 3rd row 3rd cell(index2), and write 250000
Create a cell on the 4th row 3rd cell(index2), and write 54000
Write and save the workbook
Close the file
Close the workbook
     */

    @Test
    public void excelWriteTest() throws IOException {
        // Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";

        //Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);

        //Open the workbook using fileInputStream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //Go to the first row
        Row row1 = sheet1.getRow(0);

        //Create a cell on the 3rd column (2nd index) on the first row
        Cell r1c3 = row1.createCell(2);  // r1c3 > row1 cell3

        //Write “POPULATION” on that cell
        r1c3.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet1.getRow(1).createCell(2).setCellValue("150000");

        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue("250000");

        //Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");

        //Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Close the file
        fileInputStream.close();
        fileOutputStream.close();

        //Close the workbook
        workbook.close();


    }
}
/*
Javascript is a coding language. It is used by the developers to design/create webpages (user interface).
Javascript is used to interact with the webpages.

JUnit, TestNG work with Java.

Javascript Executor is used to write in Selenium.
Testers use Javascript to do some automation script such as click,scroll, zoom in/out, hover over etc.

Javascript Executor:
Javascript Executor is an INTERFACE (can also be called API) developed by Selenium developers to execute Javascript comments/codes.
JS is used to automate Javascript comments/codes.

What can we do with JS Executor?
> Click, specially on the hidden elements.
> scroll onto specific elements, scroll all the way up/down
> Type in an input
> Change the value of an element
> Hover over
> Change the colour, background colour, add border etc.

How to create?
1. Create a reference/object (we need to downcast the webdriver)
2. Calling the method js.executeScript()

'arguments' is a keyword in executeScript method
 */
