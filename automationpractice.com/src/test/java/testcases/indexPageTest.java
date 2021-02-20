package testcases;

import com.qa.base.TestBase;
import com.qa.pages.indexPage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class indexPageTest extends TestBase {


    @BeforeTest
    public void setup(){

        initialize();

    }

    @Test
    public void test1_signin(){
        indexPage ip = new indexPage();
        ip.signin();
    }

    @Test
    public void data() throws IOException {
        indexPage ip = new indexPage();

        String excel = System.getProperty("user.dir") + "/src/main/java/com/qa/testdata/testdata.xlsx";
        FileInputStream inputSream = new FileInputStream(excel);

        XSSFWorkbook wb = new XSSFWorkbook(inputSream);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        System.out.println("rows: "+ rows);
        int column = sheet.getRow(0).getLastCellNum();
        System.out.println("column: "+ column);
        for (int r = 0; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c < column; c++) {

                XSSFCell cell = row.getCell(c);

                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        ip.validate();
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cell.getCellType());
                }


            }

        }


    }

}
