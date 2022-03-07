package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ConnectionType;

import java.util.Optional;

public class Networks {

    public WebDriver networkTest_3G()
    {
        ChromeDriver clientDriver = new ChromeDriver();

        DevTools devTools = clientDriver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Set the desired network speed
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                2000,
                50000,
                Optional.of(ConnectionType.CELLULAR3G)
        ));
        return clientDriver;

    }
    public WebDriver networkTest_2G()
    {
        ChromeDriver clientDriver = new ChromeDriver();

        DevTools devTools = clientDriver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Set the desired network speed
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                1500,
                30000,
                Optional.of(ConnectionType.CELLULAR2G)
        ));
        return clientDriver;

    }
    public WebDriver networkTest_BlueTooth()
    {
        ChromeDriver clientDriver = new ChromeDriver();

        DevTools devTools = clientDriver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Set the desired network speed
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                1500,
                30000,
                Optional.of(ConnectionType.BLUETOOTH)
        ));
        return clientDriver;

    }
    public WebDriver networkTest_4G()
    {
        ChromeDriver clientDriver = new ChromeDriver();

        DevTools devTools = clientDriver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Set the desired network speed
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                1500,
                30000,
                Optional.of(ConnectionType.CELLULAR4G)
        ));
        return clientDriver;

    }

}