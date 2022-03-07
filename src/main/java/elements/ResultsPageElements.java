package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class ResultsPageElements {

    private By seeAvailableRooms = By.xpath("//span[text()='Distance']/following::span[text()='See Available Rooms']");

    private By changeHotel = By.xpath("//p[text()='Change Hotel']");

    private By recommended = By.xpath("//span[text()='Recommended ']");

    private By lowestPrice = By.xpath("//span[text()='(Lowest First)']");

    private By distance = By.xpath("//span[text()='Distance']");

    private By reviewScore = By.xpath("//span[text()='Review Score']");

    private By starRating = By.xpath("//span[text()='Star Rating']");

    private By hotelNameSearch = By.xpath("//h3[text()='Hotel Name']/following::span[@class='multiselect__placeholder']");

    private By hotelNameSearchInput = By.xpath("input[placeholder='Hotel Name']");

    private By hotelNameLoad = By.cssSelector("div.d-flex.p-3");

    private By clearAllFilters = By.xpath("//a[text()='Clear All Filters']/parent::span");

    private final By moreButton = By.xpath("//a[contains(.,'...More')]");

    private By breakFastService = By.xpath("//span[text()='Breakfast service']/parent::div");

    private final By closeButton = By.cssSelector(".btn.custom-close.btn-secondary.btn-sm");

    private By library = By.xpath("//a[text()='Choose Your Room ']/following::span[@class='text-success font-size-14']");

    private final String contentSource = "h3:containsOwn(Property Category)";

    private final String popularFilter = "div.tab-content.pt-3";

    private final By hotelContinue = By.xpath("//div[@class='d-flex p-3']");

    private final By freeCancellation = By.xpath("//a[text()='Free Cancellation']");

    private final By freeBreakFast = By.xpath("//a[text()='Free breakfast']");

    private final By bellByService = By.xpath("//a[text()='Choose Your Room ']/following::span[@class='text-success font-size-14']");

    private final By fiveStar = By.xpath("//div[@class='d-flex p-3']/following::span[@class='start-rating ml-2 font-size-14']");

    private final String filterSection = "div.filter-list-option-check.px-2.pt-0";

    private final String elementsCheckbox = "fieldset";

    private final String showAllCondition = "a:containsOwn(Show All)";

    private By hotelPagination = By.cssSelector(".pagination.flight-list-pagination.d-flex");
}
