package com.qa.utils;

import com.qa.base.TestBase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtility extends TestBase {

    public static Object[][] getTestData() throws IOException {

        String excel = System.getProperty("user.dir") + "/src/main/java/com/qa/testdata/testdata.xlsx";
        FileInputStream inputSream = new FileInputStream(excel);

        XSSFWorkbook wb = new XSSFWorkbook(inputSream);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        System.out.println("rows: " + rows);
        int column = sheet.getRow(0).getLastCellNum();
        System.out.println("column: " + column);

        Object data[][] = new Object[rows-1][column];

        for (int r = 0; r < rows - 1; r++) {
            XSSFRow row = sheet.getRow(r +1);

            for (int c = 0; c < column; c++) {

                XSSFCell cell = row.getCell(c);

                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        data[r][c] = cell.getNumericCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        data[r][c] = cell.getStringCellValue();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cell.getCellType());


                }

            }

        }
        return data;

    }


}
