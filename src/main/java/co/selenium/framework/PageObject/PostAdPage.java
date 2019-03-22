package co.selenium.framework.PageObject;

import co.selenium.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class PostAdPage extends Pages {


    @FindBy(id = "AdTitleForm")
    WebElement txtTitle;
    @FindBy(xpath = "//span[@class='maxCharCountdown-2996436710']")
    WebElement spnCountChar;
    @FindBy(css = ".titleButton-581419873")
    WebElement btnNext;
    //@FindBy(className = "//div[@class = 'baseCard-500507516 baseCard__dark-3702095136']")
    @FindBy(xpath = "//div[@class = 'baseCard-500507516 baseCard__dark-3702095136'][1]")
    WebElement popUp;
    @FindBy(xpath = "//button[@type='button'][contains(text(),'Later')]")
    WebElement btnLater;
    public WebElement btnPostAd = Browser._driver.findElement(By.xpath("//a[@title='Post ad']"));

    public PostAdPage(WebDriver driver) { super(driver);}

    public void selectPostAd(){
        try {
            if(popUp.isDisplayed()){
                popUp.findElement(By.xpath("//button[@type='button'][contains(text(),'Later')]")).click();

                //btnLater.click();
                Browser.WaitUntilElementIsDisplayed(btnPostAd, 5000);
                btnPostAd.click();
            }
        }
        catch (Exception e){}
    }
    public void enterInvalidPostAdTitle(String title){
        txtTitle.sendKeys(title);
        if(spnCountChar.isDisplayed()){
            Assert.assertTrue(btnNext.isEnabled() == false, "Invalid character length");
        }
    }

    public void enterValidPostAdTitle(String title){
        txtTitle.sendKeys(title);
        btnNext.click();
    }
}
