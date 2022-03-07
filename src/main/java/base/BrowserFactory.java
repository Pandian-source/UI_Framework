package base;

import Data.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver clientDriver;

    public static Mobile mobile = new Mobile();

    public static Networks networks = new Networks();

    public static ConfigFileReader configFileReader = new ConfigFileReader();

    public static Dimension fDmn;

    public static WebDriver startBrowser() {

        switch (configFileReader.getBrowserName().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                clientDriver = new ChromeDriver();
                break;

            case "chrome_headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                clientDriver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                clientDriver = new FirefoxDriver(firefoxOptions);
                break;

            case "internet explorer":
                WebDriverManager.iedriver().setup();
                clientDriver = new InternetExplorerDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                clientDriver = new EdgeDriver();
                break;

            case "edge_headless":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                clientDriver = new EdgeDriver(edgeOptions);
                break;

            case "mobile" :
                clientDriver = mobile.mobileTest();
                break;

            case "safari":
                clientDriver = new SafariDriver();
                break;

            case "chrome_3g":
                clientDriver = networks.networkTest_3G();
                break;

            case "chrome_2g":
                clientDriver = networks.networkTest_2G();
                break;

            case "chrome_bluetooth":
                clientDriver = networks.networkTest_BlueTooth();
                break;

            case "chrome_4g":
                clientDriver = networks.networkTest_4G();
                break;

             default:
                throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser in the List");
        }


       // fDmn = new Dimension(Integer.valueOf(configFileReader.dimension().split("\\*")[0]), Integer.valueOf(configFileReader.dimension().split("\\*")[1]));

        clientDriver.manage().window().maximize();

        implicitlyWait(20);

        return clientDriver;
    }

    public static void implicitlyWait(long timeInSeconds) {
        clientDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

}



