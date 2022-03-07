package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class PaymentPageElements {

   private By totalRow = By.xpath("//tfoot[contains(@class,'total-value-detls')]/tr/td");

   private By creditLimit = By.xpath("//p[text()='Select Payment Mode']/following::label[1]");

   private By Terms = By.xpath("//span[@class='pointer']");

   private By confirmation = By.xpath("//h2[text()='Booking Confirmation']");

}
