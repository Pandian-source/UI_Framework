package utility;

import Data.WebElementReader;
import elements.ResultsPageElements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import pages.ResultsPage;

public class FilterMethod {

    WebDriver clientDriver;

    Document htmlDocument = null;

    WebElementReader elementReader;

    static final Logger logger = LogManager.getLogger(ResultsPage.class);

    public WaitUntil waitUntil;

    public ResultsPageElements resultsPageElements;

    public FilterMethod(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
        elementReader = new WebElementReader();
        waitUntil = new WaitUntil(clientDriver);
    }

    public Elements getElement(String elementDetails)
    {

        clickShowAll(getShowAllElement(elementDetails));

        System.out.println(clientDriver.getCurrentUrl());

        htmlDocument = elementReader.readHTMLDocument(clientDriver);

        Element resultFilter = htmlDocument.select(resultsPageElements.getFilterSection()).first();

        Element result = elementReader.findElement(resultFilter, elementDetails).parent();

        return result.select(resultsPageElements.getElementsCheckbox());
    }

    public Element getShowAllElement(String elementDetails) {

        htmlDocument = elementReader.readHTMLDocument(clientDriver);

        Element resultFilter = htmlDocument.select(resultsPageElements.getFilterSection()).first();

        Element result = elementReader.findElement(resultFilter, elementDetails).parent();

        return result.select(resultsPageElements.getShowAllCondition()).first();

    }

    public void clickShowAll(Element elementLink) {

        try {
            logger.info("Selected Checkbox : " + elementLink.text());
            WebElement link = clientDriver.findElement(By.cssSelector(elementLink.cssSelector()));
            ((JavascriptExecutor) clientDriver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", link);
            link.click();
            waitUntil.explicitWaitUntilPageLoad();
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.info(" Error " + e.getMessage());
        }
    }

    public void selectAllCheckBox(Elements elementList) {
        for (Element element : elementList) {

            logger.info("Selected Checkbox : " + element.text());

            try {
                WebElement checkbox = clientDriver.findElement(By.cssSelector(element.cssSelector()));
                ((JavascriptExecutor) clientDriver)
                        .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", checkbox);
                checkbox.click();
                waitUntil.explicitWaitUntilPageLoad();
                Thread.sleep(1000);
            } catch (Exception e) {
                logger.info(" Error " + e.getMessage());
            }
        }
    }

    public void selectCheckBox(Element elementCheckbox) {

        logger.info("Selected Checkbox : " + elementCheckbox.text());

        try {
            WebElement checkbox = waitUntil.fluentWaitMethod(
                    By.cssSelector(elementCheckbox.cssSelector()));

            ((JavascriptExecutor) clientDriver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'start'});", checkbox);
            checkbox.click();
            waitUntil.explicitWaitUntilPageLoad();
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.info(" Error while select checkbox " + e.getMessage());
        }
    }

    public int getTotalPages() {
        try {
            WebElement elementLast = clientDriver.findElement(resultsPageElements.getHotelPagination())
                    .findElement(By.linkText("Last"));

            return Integer.parseInt(
                    clientDriver.findElement(RelativeLocator.with(By.tagName("a")).near(elementLast)).getText());
        } catch (Exception e) {
            logger.info(e);
        }
        return 0;
    }
}
