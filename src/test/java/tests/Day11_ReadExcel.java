package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Day11_ReadExcel {

    /*
Notes:
Apache POI is the library used to work with Excel files in Selenium.

 */

    @Test
    public void readExcelTest() throws IOException {

        // Store the path of the  file in a string
        String path = "./src/test/java/resources/Capitals.xlsx";  // ./ makes the path the relative .. it means ignore all the previous parts of the path

        //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //Open the workbook using fileInputStream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");  // asks for sheet name  (case-sensitive)
        // OR workbook.getSheetAt(0); this asks for index of the sheet

        //Go to first row
        Row row1 = sheet1.getRow(0); // index starts at 0, going to the first ROW

        //Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0); // getCell() is used to read the data in that cell
        System.out.println("cell1 = " + cell1);

        // We can convert cell data to string as well. The benefit is we can use string manipulation methods.
        String cell1Data = cell1.toString();
        System.out.println("cell1Data = " + cell1Data);

        //Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println("cell2 = " + cell2);

        // Short way: Chaining the methods
        System.out.println(sheet1.getRow(0).getCell(1));

        // CONVERTING to string is RECOMMENDED
        //Go to 2nd row first cell  and assert if the data equal to USA
        String row2C1 = sheet1.getRow(1).getCell(0).toString();
        System.out.println("row2C1 = " + row2C1);

        assertEquals("USA", row2C1);

        //Go to 3rd row 2nd cell-chain the row and cell
        String row3C2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println("row3C2 = " + row3C2);

        //Find the number of row
        int numOfRows = sheet1.getLastRowNum()+1;  // index starts at 0 so add 1 to find total num of rows
        System.out.println("numOfRows = " + numOfRows);

        //Find the number of used row
        int usedRows = sheet1.getPhysicalNumberOfRows(); // this method will start counting the rows from 1, it will skip the row if there's no data
        System.out.println("usedRows = " + usedRows);

        //Print country, capitol key value pairs as map object
        // We need JAVA here, create an empty map that will store the country, capital pairs
        Map<String,String> countryCapitals = new HashMap<>();

        for (int rowNum =1 ; rowNum<numOfRows; rowNum++){//row index starts at 1, ends at 11
            String county = sheet1.getRow(rowNum).getCell(0).toString();
            String capital=sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(county,capital);
           //  System.out.println(countryCapitals);
        }
        System.out.println(countryCapitals);

//        // Nested loop
//        Map<String,String> map = new HashMap<>();
//        for (int i =0;i<numOfRows-1;i++){
//            for (int k = 0 ; k<1;k++){
//                map.put(sheet1.getRow(i).getCell(k).toString(),sheet1.getRow(i).getCell(k+1).toString());
//            }
//        }
//        System.out.println(map);



        //Collapse
        //Close the file
        fileInputStream.close();

        //Close the workbook
        workbook.close();

    }
}


/*

Import the apache poi dependency in your pom file
(https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml)  (https://mvnrepository.com/artifact/org.apache.poi/poi)
Create resources directory under java folder(right click on java and create the folder)
Add the excel file on the resources folder
Create a new package: excelAutomation
Create a new class : ReadExcel
Create a new test method : readExcel()
Store the path of the  file in a string
Open the file
Open the workbook using fileinputstream
Open the first worksheet
Go to first row
Go to first cell on that first row and print
Go to second cell on that first row and print
Go to 2nd row first cell  and assert if the data equal to USA
Go to 3rd row 2nd cell-chain the row and cell
Find the number of row
Find the number of used row
Print country, capitol key value pairs as map object
Collapse

 */
