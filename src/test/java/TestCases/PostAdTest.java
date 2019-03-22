package TestCases;

import co.selenium.framework.Browser;
import co.selenium.framework.PageObject.Pages;
import co.selenium.framework.TestResult;
import co.selenium.framework.Utils.ScreenshotTaker;
import org.testng.annotations.Test;


public class PostAdTest extends BaseTest {

    @Test
    public void invalidPosAdTitle(){
        try{
            Pages.Home.selectSignIn();
            Pages.loginPage.enterValidUserLogInDetail();
            Pages.loginPage.selectRememberOption();
            Pages.loginPage.clickSignInbtn();
            Pages.postAdPage.enterInvalidPostAdTitle("QA Aut");
        }
        catch (Exception exec){
            ScreenshotTaker.captureScreenShot(TestResult.FAIL, this.getClass().toString());
        }
    }

    @Test
    public void validLoginDetail(){
        try
        {
            Pages.Home.selectSignIn();
            Pages.loginPage.enterValidUserLogInDetail();
            Pages.loginPage.selectRememberOption();
            Pages.loginPage.clickSignInbtn();
        }
        catch (Exception e) {}
    }
    @Test
    public void validPosAdTitle(){
        try{
            validLoginDetail();
            Pages.postAdPage.selectPostAd();
            Pages.postAdPage.enterValidPostAdTitle("QA Automation");
        }
        catch (Exception exec){
            ScreenshotTaker.captureScreenShot(TestResult.FAIL, this.getClass().toString());
        }
    }
}
