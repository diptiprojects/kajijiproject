package TestCases;

import co.selenium.framework.PageObject.Pages;
import co.selenium.framework.TestResult;
import co.selenium.framework.Utils.ScreenshotTaker;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginWithoutCredentials(){
        try
        {
            Pages.Home.selectPostAd();
            Pages.loginPage.enterLoginDetailWithoutCredentials();
            Pages.loginPage.selectRememberOption();
            Pages.loginPage.clickSignInbtn();
        }
        catch (Exception e){
            ScreenshotTaker.captureScreenShot(TestResult.FAIL, this.getClass().toString());
        }
    }

    @Test(dependsOnMethods = "LoginWithoutCredentials")
    public void ValidUserLogin(){
        try {
            Pages.loginPage.enterValidUserLogInDetail();
            Pages.loginPage.selectRememberOption();
            Pages.loginPage.clickSignInbtn();
        }
        catch (Exception e) {
            ScreenshotTaker.captureScreenShot(TestResult.FAIL, this.getClass().toString());
        }
    }
}
