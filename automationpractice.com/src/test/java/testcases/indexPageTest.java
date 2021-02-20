package testcases;

import com.qa.base.TestBase;
import com.qa.pages.indexPage;
import com.qa.utils.TestUtility;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "data")
    public void test2(String Item, Double Price){

        System.out.println("Name: "+Item +"   Price= "+ Price);

    }



    @DataProvider
    public Object[][] data() throws IOException {
        indexPage ip = new indexPage();
        Object data[][] = TestUtility.getTestData();
        System.out.println("in test   "+data[0][1]);

        return  data;


    }

}
