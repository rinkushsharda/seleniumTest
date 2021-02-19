package testcases;

import com.qa.base.TestBase;
import com.qa.pages.indexPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class indexPageTest extends TestBase {

    @BeforeTest
    public void setup(){
        initialize();
    }

    @Test
    public  void test1_signin(){
        indexPage ip = new indexPage();
        ip.signin();
    }

}
