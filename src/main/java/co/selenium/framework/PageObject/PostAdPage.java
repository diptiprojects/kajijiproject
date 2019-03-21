package co.selenium.framework.PageObject;

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

    public PostAdPage(WebDriver driver) { super(driver);}

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
