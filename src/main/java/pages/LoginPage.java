package pages;

import elements.LoginPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WaitUntil;

import java.util.Arrays;

public class LoginPage {

    WebDriver clientDriver;

    public WaitUntil waitUntil;

    public LoginPageElements loginPageElements =  new LoginPageElements();

    public LoginPage(WebDriver clientDriver) {

        this.clientDriver = clientDriver;

        waitUntil = new WaitUntil(clientDriver);
    }
    public void hotel() throws InterruptedException {

        waitUntil.explicitWaitUntilPageLoad();

        WebElement element = clientDriver.findElement(loginPageElements.getHotel());

        System.out.println(element.getText());

        element.click();

        Thread.sleep(1000);
    }

    public void searchField(String valid) {

        try {

            waitUntil.explicitWaitUntilVisibility(loginPageElements.getLocation());

            WebElement field = clientDriver.findElement(loginPageElements.getLocation());

            field.click();

            clientDriver.findElement(loginPageElements.getLocation()).sendKeys(valid);

            By spanText = By.xpath("//span[contains(text(),'" + valid + "')]");

            WebElement elementList = waitUntil.fluentWaitMethodForFindNear(field, spanText);

            waitUntil.explicitWaitUntilClickable(elementList);

            elementList.click();
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    public void searchButton() {

        clientDriver.findElement(loginPageElements.getSearch()).click();

        waitUntil.explicitWaitUntilVisibility(loginPageElements.getHotelName());

    }

    public void doneButtonMethod() throws InterruptedException {

        clientDriver.findElement(loginPageElements.getDoneButton()).click();

        Thread.sleep(2000);
    }

    public void packageOnlyPriceMethod()
    {
        WebElement element = clientDriver.findElement(loginPageElements.getPackageOnlyPrice());

        String text = element.getText();

        if (text.equals("Include Package Price")) {
            element.getText();
        } else {
            System.out.println("element not found" + element);
        }
        clientDriver.findElement(loginPageElements.getPackageOnlyPrice()).click();
    }
}


