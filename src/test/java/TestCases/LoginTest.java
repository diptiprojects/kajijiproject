package TestCases;

import co.selenium.framework.PageObject.Pages;
import co.selenium.framework.TestResult;
import co.selenium.framework.Utils.ScreenshotTaker;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginWithoutCredentials() {
        try {
            Pages.Home.selectSignIn();
            Pages.loginPage.enterLoginDetailWithoutCredentials();
            Pages.loginPage.selectRememberOption();
            Pages.loginPage.clickSignInbtn();
        } catch (Exception e) {
            ScreenshotTaker.captureScreenShot(TestResult.FAIL, this.getClass().toString());
        }
    }

    @Test(priority = 1)
    public void ValidUserSignIn() {
        try {
            Pages.Home.selectSignIn();
            Pages.loginPage.enterValidUserLogInDetail();
            Pages.loginPage.selectRememberOption();
            Pages.loginPage.clickSignInbtn();
        } catch (Exception e) {
            ScreenshotTaker.captureScreenShot(TestResult.FAIL, this.getClass().toString());
        }
    }

}
