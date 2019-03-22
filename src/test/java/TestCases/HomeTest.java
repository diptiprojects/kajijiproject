package TestCases;

import co.selenium.framework.PageObject.Pages;
import co.selenium.framework.TestResult;
import co.selenium.framework.Utils.ScreenshotTaker;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    @Test

    public void selectSignInLink(){
        try{
            Pages.Home.selectSignIn();
        }
        catch (Exception e) {
            ScreenshotTaker.captureScreenShot(TestResult.FAIL,this.getClass().toString());
        }
    }

}
