package co.selenium.framework.PageObject;

import co.selenium.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Pages {


    @FindBy(xpath = "//a[@title='Sign In']")
    WebElement lnkSignIn;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void selectSignIn(){
        try {
            Browser.WaitUntilElementIsDisplayed(lnkSignIn, 5000);
           // Assert.assertTrue(driver.getTitle().contains("Kijiji in City of Toronto."), "Page Title has been matched");
            lnkSignIn.click();
        }
        catch (Exception e){}
    }


}
