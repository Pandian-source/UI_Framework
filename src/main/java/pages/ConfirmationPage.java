package pages;

import elements.ConfirmationElements;
import org.openqa.selenium.WebDriver;
import utility.Action;
import utility.WaitUntil;

public class ConfirmationPage {

    WebDriver clientDriver;

    public Action action;

    ConfirmationElements confirmationElements = new ConfirmationElements();

    public PaxDetailPage paxDetailPage;

    public WaitUntil waitUntil;

    public ConfirmationPage(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
        action = new Action(clientDriver);
        paxDetailPage = new PaxDetailPage(clientDriver);
        waitUntil = new WaitUntil(clientDriver);
    }
    public void tableMethod()
    {
        String tableValue = clientDriver.findElement(confirmationElements.getTable()).getText();

        System.out.println(tableValue);

        String taxesFeesValue  = clientDriver.findElement(confirmationElements.getTaxesFees()).getText();

        System.out.println(taxesFeesValue);
    }
}
