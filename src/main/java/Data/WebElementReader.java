package Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

public class WebElementReader {

    static final Logger logger = LogManager.getLogger(WebElementReader.class);

    public Document readHTMLDocument(WebDriver clientDriver) {

        try {
            String pageSource = clientDriver.getPageSource();
            return Jsoup.parse(pageSource);
        } catch (Exception e) {
            logger.info(e);
        }
        return null;
    }

    public Element findElement(Element element, String attributeCondition) {
        return element.select(attributeCondition).first();
    }

    public Element findParentElement(Element element, String attributeCondition) {
        return element.select(attributeCondition).first().parent();
    }

    public Elements findElements(Element element, String attributeCondition) {
        return element.select(attributeCondition);
    }

    public String[] findElementsWithTag(Element element, String attributeCondition, String attributeKey) {
        Elements elementList = element.select(attributeCondition);

        String[] elementsAttribute = new String[elementList.size()];
        if (elementList.size() > 1) {
            for (int i = 0; i < elementList.size(); i++)
                elementsAttribute[i] = elementList.get(i).attr(attributeKey);
        } else
            elementsAttribute[0] = elementList.get(0).attr(attributeKey);

        return elementsAttribute;
    }

    public Element findElementUsingText(Element element, String searchText) {
        return element.select(":containsOwn(" + searchText + ")").first();
    }

    public Element findParentElementUsingText(Element element, String searchText) {
        return element.select(":containsOwn(" + searchText + ")").first().parent();
    }

    public String findParentElementWithText(Element element, String searchText, String attributeKey) {
        return element.select(":containsOwn(" + searchText + ")").first().parent().attr(attributeKey);
    }

    public String findParentElementWithText(Document document, String searchText, String attributeKey) {
        return document.select(":containsOwn(" + searchText + ")").first().parent().attr(attributeKey);
    }

    public String findElementWithText(Element element, String searchText, String attributeKey) {
        return element.select(":containsOwn(" + searchText + ")").first().attr(attributeKey);
    }

    public String findElementWithText(Document document, String searchText, String attributeKey) {
        return document.select(":containsOwn(" + searchText + ")").first().attr(attributeKey);
    }
}
