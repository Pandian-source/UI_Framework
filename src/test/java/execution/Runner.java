package execution;

import base.BrowserFactory;
import Data.ConfigFileReader;
import elements.LoginPageElements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import Data.DataProvider;
import utility.Methods;
import utility.WaitUntil;

import java.time.Duration;

public class Runner {

    public Methods methods;
    public static ConfigFileReader configFileReader = new ConfigFileReader();
    public WebDriver clientDriver;
    static final Logger logger = LogManager.getLogger(Runner.class);
    public LoginPageElements loginPageElements = new LoginPageElements();
    public LoginPage loginPage;
    public ResultsPage resultsPage;
    public RoomSelectionPage roomSelectionPage;
    public PaxDetailPage paxDetailPage;
    public PaymentPage paymentPage;
    public ConfirmationPage confirmationPage;
    public WaitUntil waitUntil;

    @BeforeClass
    public void openBrowser() {

        clientDriver = BrowserFactory.startBrowser();
        System.out.println(clientDriver);
        methods = new Methods(clientDriver);
        waitUntil = new WaitUntil(clientDriver);
        loginPage = new LoginPage(clientDriver);
        resultsPage = new ResultsPage(clientDriver);
        roomSelectionPage = new RoomSelectionPage(clientDriver);
        paxDetailPage = new PaxDetailPage(clientDriver);
        paymentPage = new PaymentPage(clientDriver);
        confirmationPage = new ConfirmationPage(clientDriver);
    }
    @Test
    public void openUrl() throws InterruptedException {

        clientDriver.get(configFileReader.getApplicationUrl());
        logger.info(clientDriver.getTitle());
        Thread.sleep(1000);
    }

    @Test(dataProvider ="login", dataProviderClass = DataProvider.class)
    public void loginTest(String emailId, String Pass)
    {
    try
    {
    System.out.println(emailId + " " + Pass);

    clientDriver.findElement(loginPageElements.getLogin()).click();

    clientDriver.findElement(loginPageElements.getUserName()).clear();

    clientDriver.findElement(loginPageElements.getUserName()).sendKeys(emailId);

    clientDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    clientDriver.findElement(loginPageElements.getPassword()).clear();

    clientDriver.findElement(loginPageElements.getPassword()).sendKeys(Pass);

    clientDriver.findElement(loginPageElements.getLogin()).click();

    clientDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
    }

    @Test
    public void hotel()
     {
     try
     {
     waitUntil.explicitWaitUntilPageLoad();

     Thread.sleep(1000);

     loginPage.hotel();

     }
     catch (Exception e)
      {
     System.out.println(e);
      }
     }

    @Test
    public void locationField() {loginPage.searchField(configFileReader.locationValid());}
    @Test
    public void checkIn() {methods.homePageInputReturn();}
    @Test
    public void doneButton() throws InterruptedException {loginPage.doneButtonMethod();}
    @Test
    public void packageOnlyPrice(){loginPage.packageOnlyPriceMethod();}
    @Test
    public void searchButton() {loginPage.searchButton();}
    @Test
    public void filtercheck() throws InterruptedException {Thread.sleep(2000);resultsPage.validatePopularFilter();
   }

//    @Test
//    public void seeAvailableRoomsButton() {resultsPage.seeAvailableRoomsMethod(clientDriver);}
//    @Test
//    public void hotelNameLabel() {roomSelectionPage.hotelNameMethod(clientDriver);}
//    @Test
//    public void bookNowButton(){roomSelectionPage.bookNowButtonMethod(clientDriver);}
//    @Test
//    public void amountValue(){paxDetailPage.amountMethod(clientDriver);}
//
//    @Test
//    public void bookingInput()
//    {
//        paxDetailPage.bookingMethod(clientDriver,configFileReader.firstName(),configFileReader.lastName(),
//
//         configFileReader.phoneNumber(),configFileReader.emailId());
//    }
//    @Test
//    public void tableAmount(){paymentPage.totalRowMethod(clientDriver);}
//    @Test
//    public void paymentModes(){paymentPage.creditLimitMethod(clientDriver);}
//    @Test
//    public void confirmationPageValue(){confirmationPage.tableMethod(clientDriver);
//    }

    @AfterClass
    public void closeBrowser()
    {
        clientDriver.quit();
    }

    }




