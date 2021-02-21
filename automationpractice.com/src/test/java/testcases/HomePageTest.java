package testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.indexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    indexPage ip;
    HomePage hp;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialize();
        ip = new indexPage();
        hp = ip.validateSignIn();
    }

    @Test
    public  void validateHomePageTitle(){
        hp.validateHomePageTitle();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
