package co.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static Properties properties;
    public static WebDriver _driver;
    private static String _baseUrl = "https://www.kijiji.ca/";

    public static void Initialize() {
        _driver = Create(BrowserType.Chrome);
        //GoTo();
        _driver.manage().window().maximize();
    }

    public static WebDriver Create(BrowserType browserType) {
        switch (browserType) {
            case Chrome:
                return GetChromeDriver();
            case FireFox:
                return GetFireFoxDriver();
            default:
                throw new NoSuchElementException("No Such browser found");
        }
    }

    public static String getProperty(String key) {
        try {
            if (properties == null) {
                properties = new Properties();
                Path path = Paths.get("src", "main", "resources", "driverconfig.properties");
                FileInputStream fileInputStream = new FileInputStream(path.toFile());
                properties.load(fileInputStream);
            }
        } catch (IOException io) {
        }
        return properties.get(key).toString();
    }

    private static WebDriver GetChromeDriver() {
        System.setProperty("webdriver.chrome.driver", getProperty("chrome-driver-path"));
        return new ChromeDriver();
    }

    private static WebDriver GetFireFoxDriver() {
        System.setProperty("webdriver.chrome.driver", getProperty("gecko-driver-path"));
        return new FirefoxDriver();
    }

    public static void GoTo() {
        _driver.navigate().to(_baseUrl);
    }

    public static boolean WaitUntilElementIsDisplayed(WebElement element, int timeout) {
        try{
            for(int i =0; i <= timeout; i++){
                if(ElementIsDisplayed(element)){
                    return true;
                }
                Thread.sleep(1000);
            }
        }
        catch (Exception e){}
        return false;
    }

    public static boolean ElementIsDisplayed(WebElement element){
        boolean _present = false;
        try{
            _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            _present = (element).isDisplayed();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return _present;
    }

    public static void Quit() {
        _driver.quit();
    }
}
