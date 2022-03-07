package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;

import java.util.Optional;

public class Mobile {

    public WebDriver mobileTest() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver clientDriver = new ChromeDriver();
        DevTools devTools = clientDriver.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setDeviceMetricsOverride(375,
                812,
                100,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        return clientDriver;
    }
}
