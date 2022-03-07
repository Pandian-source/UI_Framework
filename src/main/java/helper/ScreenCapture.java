package helper;

import Data.ConfigFileReader;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenCapture {

    static final Logger logger = LogManager.getLogger(ScreenCapture.class);

    ConfigFileReader configReader;

    public String takeScreenSnapShot(WebDriver webDriver, String fileName) throws Exception
    {
        configReader = new ConfigFileReader();

        String path = configReader.getBaseDir() + "/Reports/";

        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);

        String destinationFileName = path + fileName + ".png";

        logger.info("file Path Name " + destinationFileName);

        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(sourceFile, new File(destinationFileName));

        return fileName + ".png";
    }
    public String takeScreenSnapShotWithFullPage(WebDriver webDriver, String fileName) throws Exception {
        configReader = new ConfigFileReader();
        String path = configReader.getBaseDir() + "/Reports/";
        //  String destinationFileName = path + fileName + ".png";
        Shutterbug.shootPage(webDriver, Capture.FULL_SCROLL)
                .withName(fileName)
                .withThumbnail(0.3)
                .save(path);
        return fileName + ".png";
    }
}
