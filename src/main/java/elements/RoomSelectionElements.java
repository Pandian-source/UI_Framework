package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class RoomSelectionElements {

   private By hotelName = By.xpath("//a[text()='Hotel Info']/following::h5");

    private By bookNowButton = By.xpath("//button[text()='Get Price']/following::span[text()='Book Now'][1]");

    private By currencyAmount = By.xpath("(//span[contains(.,'Book Now')])[1]/preceding::span[@class='price_secondary_color price_view orange']");

    private By priceDetails = By.xpath("//p[text()='Price Details']");

}
