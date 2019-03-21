package co.selenium.framework.Utils;

import co.selenium.framework.Browser;
import co.selenium.framework.TestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;

public class ScreenshotTaker extends Browser {

    public static void captureScreenShot(TestResult status, String fileName) {
        String directory;
        try{
            if(status == TestResult.FAIL) {
                directory = getProperty("failTestScreenshotPath");
                FileUtils.forceMkdir(new File(directory));
                File sourceFile = ((TakesScreenshot)_driver).getScreenshotAs(OutputType.FILE);
                File targetFile = new File(directory.toString() + "/" + fileName + ".png");
                FileUtils.copyFile(sourceFile,targetFile);
            }
        }
        catch (IOException e) {

        }
    }

}
