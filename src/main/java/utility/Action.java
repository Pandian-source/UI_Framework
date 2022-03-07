package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Action {

    WebDriver clientDriver;

    public Action(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
    }

    public void scrollToElement(WebElement element) {

        ((JavascriptExecutor) clientDriver)
                .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);


    }
}
