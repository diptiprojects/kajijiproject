package TestCases;

import co.selenium.framework.PageObject.MainPage;
import co.selenium.framework.PageObject.Pages;
import co.selenium.framework.TestResult;
import co.selenium.framework.Utils.ScreenshotTaker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    WebDriver driver;
    @Test

    public void selectPostAdLink(){
        try{
            Pages.Home.selectPostAd();
        }
        catch (Exception e) {
            ScreenshotTaker.captureScreenShot(TestResult.FAIL,this.getClass().toString());
        }
    }

}
