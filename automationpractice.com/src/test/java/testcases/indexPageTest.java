package testcases;

import com.qa.base.TestBase;
import com.qa.pages.indexPage;
import com.qa.utils.TestUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class indexPageTest extends TestBase {

    indexPage ip;

    public indexPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialize();
        ip = new indexPage();
    }

    @Test(priority = 1)
    public void validateIndexPageTitleTest(){
        Assert.assertEquals(ip.validateIndexPageTitle(), "My Store");
    }

    @Test(priority = 2)
    public void validateLoginImageTest(){
        Assert.assertTrue(ip.validateLogoImage());
    }

    @Test(priority = 3)
    public void validateSignInTest(){
        ip.validateSignIn();
    }

    @Test(dataProvider = "data", priority = 4)
    public void validateBlousePriceTest(String Item, String Price){
        String actual = ip.validateBlousePrice();
        Assert.assertEquals(Price, actual);
    }

    @DataProvider
    public Object[][] data() throws IOException {
        Object data[][] = TestUtility.getTestData();
        return  data;
    }

}
