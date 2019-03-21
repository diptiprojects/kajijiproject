package co.selenium.framework.PageObject;

import co.selenium.framework.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    public static WebDriver driver;
    public Pages(WebDriver driver) {
        driver = Browser._driver;
        PageFactory.initElements(driver,this);
    }

    public static MainPage Home = new MainPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
}
