package co.selenium.framework.PageObject;

import co.selenium.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Pages {

    public WebElement btnPostAd = Browser._driver.findElement(By.xpath("//a[@title='Post ad']"));

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void selectPostAd(){
        try {
            Browser.WaitUntilElementIsDisplayed(btnPostAd, 5000);
            btnPostAd.click();
        }
        catch (Exception e){}
    }
}
