package pages;

import elements.ResultsPageElements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import utility.FilterMethod;
import utility.WaitUntil;

import java.util.List;

import static org.openqa.selenium.By.*;


public class ResultsPage {

    WebDriver clientDriver;

    public WaitUntil waitUntil;

    ResultsPageElements resultsPageElements = new ResultsPageElements();

    static final Logger logger = LogManager.getLogger(ResultsPage.class);

    public FilterMethod filterMethod;

    public ResultsPage(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
        waitUntil = new WaitUntil(clientDriver);
        filterMethod = new FilterMethod(clientDriver);

    }
    public void seeAvailableRoomsMethod()
    {
        clientDriver.findElement(resultsPageElements.getSeeAvailableRooms()).click();

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getChangeHotel());
    }

    public void recommendedMethod() {

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getRecommended());

        clientDriver.findElement(resultsPageElements.getRecommended()).isDisplayed();

        clientDriver.findElement(resultsPageElements.getRecommended()).click();
    }

    public void distanceMethod() {

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getDistance());

        clientDriver.findElement(resultsPageElements.getDistance()).isDisplayed();

        clientDriver.findElement(resultsPageElements.getDistance()).click();

        clientDriver.findElement(resultsPageElements.getDistance()).click();
    }

    public void reviewScoreMethod() {

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getReviewScore());

        clientDriver.findElement(resultsPageElements.getReviewScore()).isDisplayed();

        clientDriver.findElement(resultsPageElements.getReviewScore()).click();

        clientDriver.findElement(resultsPageElements.getReviewScore()).click();
    }

    public void starRatingMethod() {

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getStarRating());

        clientDriver.findElement(resultsPageElements.getStarRating()).isDisplayed();

        clientDriver.findElement(resultsPageElements.getStarRating()).click();

        clientDriver.findElement(resultsPageElements.getStarRating()).click();
    }

    public void lowestPriceMethod() throws InterruptedException {

        waitUntil.explicitWaitUntilPageLoad();

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getLowestPrice());

        clientDriver.findElement(resultsPageElements.getLowestPrice()).isDisplayed();

        clientDriver.findElement(resultsPageElements.getLowestPrice()).click();

        clientDriver.findElement(resultsPageElements.getLowestPrice()).click();

        Thread.sleep(1000);
    }

    public void hotelNameSearchMethod() {

        waitUntil.explicitWaitUntilPageLoad();

        clientDriver.findElement(resultsPageElements.getHotelNameSearch()).click();

        clientDriver.findElement(resultsPageElements.getHotelNameSearch()).click();

        clientDriver.findElement(resultsPageElements.getHotelNameSearch()).sendKeys(Keys.ENTER);

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getHotelNameLoad());

        String name = clientDriver.findElement(resultsPageElements.getHotelNameLoad()).getText();

        System.out.println(name);

        waitUntil.explicitWaitUntilVisibility(resultsPageElements.getClearAllFilters());

        clientDriver.findElement(resultsPageElements.getClearAllFilters()).click();
    }

    public By breakFastService() {
        try {
            List<WebElement> more = clientDriver.findElements(resultsPageElements.getMoreButton());

         //  more.forEach(ele-> ele.click());

        //   more.stream().forEach(ele-> System.out.println(ele.getText()));

            for (WebElement ele : more)
            {
                ele.click();
                waitUntil.explicitWaitUntilVisibility(resultsPageElements.getBreakFastService());
                String text =  clientDriver.findElement(resultsPageElements.getBreakFastService()).getText();
                System.out.println(text);
                clientDriver.findElement(resultsPageElements.getCloseButton()).click();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean validatePopularFilter() {
        try {
            Elements arriveAtCheckboxes = filterMethod.getElement(resultsPageElements.getPopularFilter());
            for (Element checkbox : arriveAtCheckboxes)
            {
                System.out.println(checkbox.text());
                filterMethod.selectCheckBox(checkbox);
                waitUntil.explicitWaitUntilPageLoad();
                Thread.sleep(3000);
                if (checkbox.text().contains("Free Cancellation"))
                {
                    if (!verifyPopularFilter(resultsPageElements.getFreeCancellation()))
                        return false;
                } else if(checkbox.text().contains("Free breakfast"))
                {
                    if (!verifyPopularFilter(resultsPageElements.getFreeBreakFast()))
                        return false;
                } else if(checkbox.text().contains("Bellboy service"))
                {
                    if(!verifyPopularFilter(resultsPageElements.getBellByService()))
                        return false;
                }else if(checkbox.text().contains("5 Star"))
                {
                    if(!verifyPopularFilter(resultsPageElements.getFiveStar()))
                        return false;
                     List<WebElement> star = clientDriver.findElements(resultsPageElements.getFiveStar());

                     for(WebElement ele : star)
                     {
                       int starCount =  ele.findElements(xpath("//i[@class='fa fa-star checked']")).size();

                       System.out.println(starCount);

                     }
                }else if (checkbox.text().contains("Library"))
                {
                    try
                    {
                        if(!verifyPopularFilter(resultsPageElements.getLibrary()))
                        return false;

                    }catch (Exception e)
                    {
                        System.out.println(e.getStackTrace());
                    }

                }
                else if (checkbox.text().contains("Breakfast service"))
                {
                    try {
                        if (!verifyPopularFilter(breakFastService()))
                            return false;
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getStackTrace());
                    }

                }
                filterMethod.selectCheckBox(checkbox);
                waitUntil.explicitWaitUntilPageLoad();
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            logger.info(e);
        }
        return true;
    }

        public boolean verifyPopularFilter(By elementPath){
            try {

                int i = 1;
                int totalPages = filterMethod.getTotalPages();
                logger.info("Total Pages is " + totalPages);
                do {
                    i++;
                    try {
                        List<WebElement> flightContList = waitUntil.fluentWaitMethodFindElements(resultsPageElements.getHotelContinue());

                        for (WebElement element : flightContList)

                            element.findElement(elementPath);


                    } catch (Exception e) {
                        logger.info(e);
                        return false;
                    }

                    if (i <= totalPages) {
                        waitUntil.fluentWaitMethod(filterMethod.resultsPageElements.getHotelPagination())
                                .findElement(linkText("" + i)).click();
                        waitUntil.explicitWaitUntilPageLoad();
                        Thread.sleep(2000);
                    }
                } while (i <= totalPages);

            } catch (Exception e) {
                logger.info(e);
                return false;
            }
            return true;


        }
    }




