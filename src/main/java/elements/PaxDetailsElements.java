package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class PaxDetailsElements {

    private By amount = By.xpath("//span[contains(@class,'view')]");

    private By firstName = By.xpath("//span[text()='1']/following::input[1]");

    private By lastName = By.xpath("//span[text()='1']/following::input[2]");

    private By phoneNumber = By.xpath("//span[text()='1']/following::input[4]");

    private By email = By.xpath("//p[text()='Confirmation email ']/following::input");

    private By continueButton = By.cssSelector("button[type='submit']");

    private By continueBook = By.xpath("//button[text()='Confirm & Book']");


}
