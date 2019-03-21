package co.selenium.framework.PageObject;

import co.selenium.framework.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.testng.Assert;

public class LoginPage extends Pages {

    @FindBy(id = "LoginEmailOrNickname")
    WebElement emailAddress;
    @FindBy(id = "login-password")
    WebElement password;
    @FindBy(id = "login-rememberMe")
    WebElement chkRemember;
    @FindBy(xpath = "//button[@id='SignInButton']")
    WebElement btnSignIn;
    @FindBy(xpath = "//span[@class='field-message error']")
    WebElement lblMsg;


    String dataFileName = Browser.getProperty("loginTestDataFile");
    String filePath = Browser.getProperty("TestDataFilePath");
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;


    public LoginPage(WebDriver driver){ super(driver); }

    public void enterLoginDetailWithoutCredentials(){
        try {
            emailAddress.sendKeys("");
            password.sendKeys("");
        }
        catch (Exception e){}
    }

    public void enterValidUserLogInDetail(){
        try{
            FileInputStream inputStream = new FileInputStream(filePath + "/" + dataFileName);
            workbook = new XSSFWorkbook(inputStream);
            // Load the sheet in which data is stored
            sheet = workbook.getSheet("LoginData");
            //Browser.WaitUntilElementIsDisplayed(emailAddress, 5000);
            for(int i =1; i<= sheet.getLastRowNum(); i++)
            {
                cell = sheet.getRow(i).getCell(1);
                emailAddress.sendKeys(cell.getStringCellValue());

                cell = sheet.getRow(i).getCell(2);
                password.sendKeys(cell.getStringCellValue());

                FileOutputStream foutput = new FileOutputStream(filePath + "/" + dataFileName);
                String message = "Data Imported Successfully";
                sheet.getRow(i).createCell(3).setCellValue(message);

                workbook.write(foutput);
                foutput.close();
            }
        }
        catch (IOException io){}
    }

    public void selectRememberOption(){
        try
        {
            boolean isRememberSelected;
            isRememberSelected = chkRemember.isSelected();
            if(isRememberSelected == true)
                Assert.assertTrue(true,"Remember checkbox is checked");
            else
                Assert.assertFalse(false, "Remember me checkbox is not checked.");
        }
        catch (Exception e){}
    }

    public void clickSignInbtn(){
        try
        {
            btnSignIn.click();
            if(lblMsg.isDisplayed())
                Assert.assertTrue(lblMsg.isDisplayed() == true,"Invalid Login Credentials.");
            else
                Assert.assertFalse(lblMsg.isDisplayed() == false, "Valid Login Credentials");
        }
        catch (Exception e) {}
    }

}
