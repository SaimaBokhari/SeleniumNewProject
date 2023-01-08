package practices.practice06;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q01  {
    /*
    An Example of DATA DRIVEN TEST

    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the highest earnings amount.
    Then
        Assert that row number of Wednesday is 1
     */

    @Test
    public void test() throws IOException {
        // In the row column, write the row numbers according to the highest earnings amount.
        // to read Excel file , we use FileInputStream

        String path = "./src/test/java/resources/EarningList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        List<Double> earnings = new ArrayList();

        for (int i=1; i<=sheet1.getLastRowNum(); i++){
           earnings.add(Double.valueOf(sheet1.getRow(i).getCell(1).toString()));
        }
        System.out.println("earnings = " + earnings);
        System.out.println("=======================");

        // Create an empty list to sort the earnings in natural order

        List<Double> sortedEarnings = new ArrayList<>(earnings);
        Collections.sort(sortedEarnings);
        Collections.reverse(sortedEarnings);

        System.out.println("sortedEarnings = " + sortedEarnings);

        // Create a nested loop to compare the values of the two lists,
        // so where ever the values are equal, we'll get that index and assign to the row

        for (int i=0; i<sortedEarnings.size(); i++){  // i is the index of sorted List
            for (int j=0; j< earnings.size(); j++){   // j is the index of unsorted List
                if (sortedEarnings.get(i)==earnings.get(j)){
                    sheet1.getRow(j+1).createCell(2).setCellValue(i+1);
                }
            }
        }
        // To send the values to Excel file
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);


        // Assert that row number of Wednesday is 1
        Cell cell = sheet1.getRow(3).getCell(2);
        assertEquals("1.0", cell.toString() );

    }
}
