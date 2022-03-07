package pages;

import elements.RoomSelectionElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Action;
import utility.WaitUntil;

public class RoomSelectionPage {

    WebDriver clientDriver;

    public Action action;

    public WaitUntil waitUntil;

    RoomSelectionElements roomSelectionElements = new RoomSelectionElements();

    public String amount = "";

    public RoomSelectionPage(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
        action = new Action(clientDriver);
        waitUntil = new WaitUntil(clientDriver);

    }

    public void hotelNameMethod()
    {
     String hotelName =   clientDriver.findElement(roomSelectionElements.getHotelName()).getText();

     System.out.println(hotelName);
    }

    public void bookNowButtonMethod(){

      WebElement webElement = clientDriver.findElement(roomSelectionElements.getBookNowButton());

      action.scrollToElement(webElement);

      amount  = clientDriver.findElement(roomSelectionElements.getCurrencyAmount()).getText();

      System.out.println(amount);

      clientDriver.findElement(roomSelectionElements.getBookNowButton()).click();

      waitUntil.explicitWaitUntilPageLoad();

      waitUntil.explicitWaitUntilVisibility(roomSelectionElements.getPriceDetails());
    }
}
