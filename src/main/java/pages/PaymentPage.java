package pages;

import elements.PaxDetailsElements;
import elements.PaymentPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WaitUntil;

import java.util.List;

public class PaymentPage {

    WebDriver clientDriver;

    public WaitUntil waitUntil;

    PaxDetailsElements paxDetailsElements = new PaxDetailsElements();

    PaymentPageElements paymentPageElements = new PaymentPageElements();

    public float totalAmount=0.0f;

    public float paybleAmount = 0.0f;

    public PaymentPage(WebDriver clientDriver)
    {
        this.clientDriver = clientDriver;
        waitUntil = new WaitUntil(clientDriver);
    }
    public void totalRowMethod()
    {

      List<WebElement> row = clientDriver.findElements(paymentPageElements.getTotalRow());

      System.out.println(row.size());

      for(int i=1;i<= row.size();i++)
      {
          if (i <= row.size()-1)
          {
              String element = "//tfoot[contains(@class,'total-value-detls')]/tr/td[" + i + "]";

              if (element!=" ")
              {
                  totalAmount = +Float.parseFloat(clientDriver.findElement(By.xpath(element)).getText().trim());

                  System.out.println(totalAmount);
              }
          }
          else if(i>= row.size())
          {

              String element ="//tfoot[contains(@class,'total-value-detls')]/tr/td["+i+"]";

              paybleAmount = +Float.parseFloat(clientDriver.findElement(By.xpath(element)).getText().trim());

              System.out.println(paybleAmount);
          }
      }
      if(totalAmount==paybleAmount)
      {
          System.out.println("Amount is Equal");
      }
      else
      {
          System.out.println("Amount is Not Equal");
      }
    }
 public void creditLimitMethod()
 {
     String limit = clientDriver.findElement(paymentPageElements.getCreditLimit()).getText();

     System.out.println(limit);

     clientDriver.findElement(paymentPageElements.getTerms()).click();

     clientDriver.findElement(paxDetailsElements.getContinueBook()).click();

     waitUntil.explicitWaitUntilPageLoad();

     waitUntil.explicitWaitUntilVisibility(paymentPageElements.getConfirmation());
 }

}
