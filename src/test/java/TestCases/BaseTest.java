package TestCases;

import co.selenium.framework.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Logger;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        Logger.getLogger("************************ TEST STARTED");
        Browser.Initialize();
        Browser.GoTo();
    }

    @AfterSuite
    public void tearDown(){
        if(Browser._driver == null) {
            Browser.Quit();
        }
    }
}
