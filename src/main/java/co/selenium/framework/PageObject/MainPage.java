package co.selenium.framework.PageObject;

import co.selenium.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends Pages {

    public WebElement btnPostAd = Browser._driver.findElement(By.xpath("//a[@title='Post ad']"));
    @FindBy(xpath = "//a[@title='Sign In']")
    WebElement lnkSignIn;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void clickOnSignIn(){
        try {
            Browser.WaitUntilElementIsDisplayed(lnkSignIn, 5000);
            Assert.assertTrue(driver.getTitle().contains("Kijiji in City of Toronto. - Buy, Sell & Save with Canada's #1 Local Classifieds."), "Page Title has been matched");
            lnkSignIn.click();
        }
        catch (Exception e){}
    }

    public void selectPostAd(){
        try {
            Browser.WaitUntilElementIsDisplayed(btnPostAd, 5000);
            btnPostAd.click();
        }
        catch (Exception e){}
    }
}
