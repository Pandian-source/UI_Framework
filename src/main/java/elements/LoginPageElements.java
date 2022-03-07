package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class LoginPageElements {

    private By userName = By.cssSelector("input[placeholder='Enter Your Email*']");

    private By password = By.cssSelector("input[placeholder='Enter Password*']");

    private By login = By.cssSelector("button[type='submit']");

    private By hotel = By.xpath("//a[contains(.,'Hotels')]");

    private By location = By.xpath("//input[contains(@placeholder,'Enter a Hotel Name or Destination')]");

    private By search = By.xpath("(//button[contains(.,'Search')])[2]");

    private By checkIn = By.xpath("//input[@placeholder='Check-in']");

    private By checkOut = By.xpath("//input[@placeholder='Check-out']");

    private By nextMonth = By.xpath("//button[@aria-label='Move forward to switch to the next month.']");

    private By prevMonth = By.xpath("//button[@aria-label='Move backward to switch to the previous month.']");

    private By monthName = By.xpath("//div[@class='asd__month-name']");

    private By neighBourHood = By.xpath("//input[@placeholder='Neighbourhood']");

    private By doneButton = By.xpath("//div[@class='mt-4 text-center']//span[@class='cursor done_btn'][normalize-space()='Done']");

    private By packageOnlyPrice = By.xpath("//label[contains(.,'Include Package Price')]");

    private By hotelName = By.xpath("//h3[text()='Hotel Name']");

}
