package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUntil {

    static final Logger log = LogManager.getLogger(WaitUntil.class);
    WebDriver clientDriver;

    public WaitUntil(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
    }

    public WebElement fluentWaitMethod(By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(elementPath));
    }

    public List<WebElement> fluentWaitMethodFindElements(By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElements(elementPath));
    }

    public WebElement fluentWaitMethodForFindBelow( WebElement webElement, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).below(webElement)));
    }

    public WebElement fluentWaitMethodForFindNear( WebElement webElement, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).near(webElement)));
    }

    public List<WebElement> fluentWaitMethodForFindBelowElements(WebElement webElement,
                                                                 By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElements(RelativeLocator.with(elementPath).below(webElement)));
    }

    public WebElement fluentWaitMethodForFindRight( WebElement webElement, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).toRightOf(webElement)));
    }

    public WebElement fluentWaitMethodForFindBelow(By webElementBy, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).below(webElementBy)));
    }

    public WebElement fluentWaitMethodFindElement(WebElement webElement, By elementPath) {
        Wait<WebElement> fluentWait = new FluentWait<>(webElement).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(element1 -> element1.findElement(elementPath));
    }

    public void explicitWaitUntilVisibility(By elementPath) {
        @SuppressWarnings("deprecation")
        WebDriverWait wait = new WebDriverWait(clientDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementPath));
    }

    public void explicitWaitUntilPresenceOfElementLocated(By elementPath) {
        @SuppressWarnings("deprecation")
        WebDriverWait wait = new WebDriverWait(clientDriver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementPath));
    }

    public void explicitWaitUntilPageLoad() {
            try {
                org.openqa.selenium.JavascriptExecutor j = (org.openqa.selenium.JavascriptExecutor) clientDriver;
                j.executeScript("return document.readyState").toString();
            } catch (Exception exe) {
                exe.printStackTrace();
            }
    }

    public void explicitWaitUntilClickable( By elementPath) {

        @SuppressWarnings("deprecation")
        WebDriverWait wait = new WebDriverWait(clientDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elementPath));
    }

    public void explicitWaitUntilClickable(WebElement element) {

        @SuppressWarnings("deprecation")
        WebDriverWait wait = new WebDriverWait(clientDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void threadWaitUntilElementInvisible( By elementPath) {
        try {
            int i = 1;
            WebElement element=clientDriver.findElement(elementPath);
            while (i <= 1200) {
                if(element.isDisplayed()) {
                    Thread.sleep(100);
                }
                i++;
            }
        } catch (Exception e) {
            log.info("Element disappeared...");
        }
    }
    public void threadWaitUntilElementInvisible( By elementPath,int seconds) {
        try {
            int i = 1;
            WebElement element=clientDriver.findElement(elementPath);
            while (i <= seconds) {
                if(element.isDisplayed()) {
                    Thread.sleep(1000);
                }
                i++;
            }
        } catch (Exception e) {
            log.info("Element disappeared...");
        }
    }
    public void waitUntilElementInvisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(clientDriver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitUntilElementVisible( WebElement element) {
        WebDriverWait wait = new WebDriverWait(clientDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementVisible( By elementPath) {
        WebDriverWait wait = new WebDriverWait(clientDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementPath));
    }
    public WebElement fluentWaitMethodForFindNear(By webElementBy, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(clientDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).near(webElementBy)));
    }

}

