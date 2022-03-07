package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class ConfirmationElements {

    private By table = By.xpath("//div[@class='mb-4 travel_price_total_section gray_background']");

    private By taxesFees = By.xpath("//div[@class='mb-3 travel_price_total_section gray_background travel-price-sec']");
}
