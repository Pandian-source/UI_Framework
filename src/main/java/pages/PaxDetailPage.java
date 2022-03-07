package pages;

import elements.PaxDetailsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Action;
import utility.WaitUntil;

public class PaxDetailPage {

    WebDriver clientDriver;

    public WaitUntil waitUntil;

    public Action action;

    PaxDetailsElements paxDetailsElements = new PaxDetailsElements();

    public RoomSelectionPage roomSelectionPage;

    public PaxDetailPage(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
        waitUntil = new WaitUntil(clientDriver);
        action = new Action(clientDriver);
        roomSelectionPage = new RoomSelectionPage(clientDriver);
    }
    public void amountMethod(){

      String amountValue =  clientDriver.findElement(paxDetailsElements.getAmount()).getText();

      System.out.println(amountValue);

      if(amountValue.equals(roomSelectionPage.amount))
      {
          System.out.println("Amount is Equal");
      }
      else
      {
          System.out.println("Amount is Not Equal");
      }
    }
    public void bookingMethod(String firstName, String lastName,String phoneNumber,String email){

        WebElement fName = clientDriver.findElement(paxDetailsElements.getFirstName());

        action.scrollToElement(fName);

        clientDriver.findElement(paxDetailsElements.getFirstName()).click();

        clientDriver.findElement(paxDetailsElements.getFirstName()).sendKeys(firstName);

        clientDriver.findElement(paxDetailsElements.getLastName()).click();

        clientDriver.findElement(paxDetailsElements.getLastName()).sendKeys(lastName);

        clientDriver.findElement(paxDetailsElements.getPhoneNumber()).click();

        clientDriver.findElement(paxDetailsElements.getPhoneNumber()).sendKeys(phoneNumber);

        clientDriver.findElement(paxDetailsElements.getEmail()).click();

        clientDriver.findElement(paxDetailsElements.getEmail()).sendKeys(email);

        WebElement belowContinue = clientDriver.findElement(paxDetailsElements.getContinueButton());

        action.scrollToElement(belowContinue);

        clientDriver.findElement(paxDetailsElements.getContinueButton()).click();

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(paxDetailsElements.getContinueBook());
    }
}
