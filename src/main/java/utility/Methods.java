package utility;

import Data.ConfigFileReader;
import elements.LoginPageElements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import pages.LoginPage;
import java.time.Month;

public class Methods
{
    WebDriver clientDriver;

    static final Logger logger = LogManager.getLogger(Methods.class);

    public int maximumMonth = 12;

    public LoginPage login;

    public WaitUntil waitUntil;

    public ConfigFileReader configFileReader = new ConfigFileReader();

    public LoginPageElements loginPageElements = new LoginPageElements();

    public Methods(WebDriver clientDriver) {
        this.clientDriver = clientDriver;
        login = new LoginPage(clientDriver);
        waitUntil = new WaitUntil(clientDriver);
    }

    public void setDate(WebElement elementNextMonth, String travelDate)
    {
        try {
            int monthNumber = 0;

            do {
                WebElement  nextMonth = clientDriver.findElement(RelativeLocator.with(loginPageElements.getNextMonth()).below(loginPageElements.getCheckIn()));

                WebElement  month = clientDriver.findElement(RelativeLocator.with(loginPageElements.getMonthName()).near(nextMonth));

                System.out.println("Month Name:"+month.getText());

                String strMonth = month.getText().replaceAll("[^A-Z]", "").trim();

                Integer numMonth = getMonthNumber(strMonth);

                Integer tvlMonth = Integer.parseInt(travelDate.split("-")[1].trim());
                try {

                    WebElement elementTravelDate = clientDriver.findElement(
                            RelativeLocator.with(By.xpath("//div[@date=\"" + travelDate + "\"]")).below(elementNextMonth));
                    if (elementTravelDate.isDisplayed()) {
                        elementTravelDate.click();
                        return;
                    }

                } catch (Exception e) {
                    System.out.println("Multi Date dispaly issue " + e.getMessage());
                }
                if (numMonth > tvlMonth) {
                    WebElement prevMonth = clientDriver.findElement(RelativeLocator.with(loginPageElements.getPrevMonth()).near(month));
                    waitUntil.explicitWaitUntilClickable(prevMonth);
                    prevMonth.click();
                } else {
                    waitUntil.explicitWaitUntilClickable(elementNextMonth);
                    elementNextMonth.click();
                }

                monthNumber++;
            } while (monthNumber < maximumMonth);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

    public void homePageInputReturn()
    {
        String[] returnTripDetails = configFileReader.getProperty("checkin").split(",");

        setReturnDate(returnTripDetails[0], returnTripDetails[1]);

    }

    public void setReturnDate( String checkInDate,String checkOutDate) {
        try {

            WebElement location = waitUntil.fluentWaitMethod(loginPageElements.getLocation());

            WebElement neighbour = waitUntil.fluentWaitMethodForFindRight(location,
                    loginPageElements.getNeighBourHood());

            WebElement elementDepartDateInput = waitUntil.fluentWaitMethodForFindRight(neighbour,
                    loginPageElements.getCheckIn());
            elementDepartDateInput.click();

            setDate(waitUntil.fluentWaitMethodForFindBelow(elementDepartDateInput,
                    loginPageElements.getNextMonth()), checkInDate);

            WebElement elementReturnDateInput = waitUntil.fluentWaitMethodForFindRight(
                    elementDepartDateInput, loginPageElements.getCheckOut());
            elementReturnDateInput.click();

            setDate(waitUntil.fluentWaitMethodForFindBelow(elementReturnDateInput,
                    loginPageElements.getNextMonth()), checkOutDate);

        } catch (Exception e) {
            logger.info("Return : " + e.getMessage());
        }


    }

}