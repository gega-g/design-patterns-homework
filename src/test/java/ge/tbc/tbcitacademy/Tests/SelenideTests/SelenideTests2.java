package ge.tbc.tbcitacademy.Tests.SelenideTests;

import ge.tbc.tbcitacademy.Tests.Configuration.ConfigTests;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.listeners.ReportListener.CustomReportListener;
import ge.tbc.tbcitacademy.listeners.SuiteListener.CustomSuiteListener;
import ge.tbc.tbcitacademy.listeners.TestListener.CustomTestListener;
import ge.tbc.tbcitacademy.pages.BooksPage;
import ge.tbc.tbcitacademy.pages.DemosPage;
import ge.tbc.tbcitacademy.pages.PricingPage;
import ge.tbc.tbcitacademy.steps.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomReportListener.class, CustomTestListener.class, CustomSuiteListener.class})
public class SelenideTests2 extends ConfigTests {
    DemosPage demosPage = new DemosPage();
    DemosPageSteps demosPageSteps = new DemosPageSteps();
    PricingPage pricingPage = new PricingPage();
    CommonSteps commonSteps = new CommonSteps();
    PricingPageSteps pricingPageSteps = new PricingPageSteps();
    OrderPageSteps orderPageSteps = new OrderPageSteps();
    ContactInfoPageSteps contactInfoPageSteps = new ContactInfoPageSteps();
    BooksPage booksPage = new BooksPage();
    BooksPageSteps booksPageSteps = new BooksPageSteps();

    @Test(description = Constants.DEMOSDESC)
    public void validateDemosDesign() {
        demosPage
                .navigateToDemosPage()
                .navigateToWeb();
        demosPageSteps
                .validateColorAndTextForWeb();
        demosPage
                .navigateToDesktop();
        demosPageSteps
                .microsoftButtonOnDesktopElement();
        demosPage
                .navigateToMobile();
        demosPageSteps
                .xamarinValidations();
        demosPage
                .selectionBarIsSticky()
                .selectionBarNavigatesToCorrectElement();
    }

    @Test(description = Constants.ORDERDESC)
    public void validateOrderMechanics() {
        pricingPage
                .navigateToPricingPage();
        commonSteps
                .acceptCookies();
        pricingPageSteps
                .buyDevCraftUltimate();
        orderPageSteps
                .UnitPriceEqualsTotalPrice()
                .setQuantityOnTwo()
                .isExpectedTotalPriceCorrect()
                .isDiscountCorrectOnHover()
                .clickOnContinue();
        commonSteps
                .acceptCookies();
        contactInfoPageSteps
                .fillDropDown()
                .fillRest()
                .navigateBackAndForward()
                .isTextStillFilled();
    }

    @Test(description = Constants.CHAINEDDESC)
    public void chainedLocatorsTest() {
        booksPage
                .navigateToBooksPage();
        booksPageSteps
                .JSBooksByMedia();
    }

    @Test(description = Constants.RADIOCHECKBOXDESC)
    public void softAssertTest() {
        booksPage
                .navigateToBooksPage();
        booksPageSteps
                .findAllBooksFromTable()
                .correctBooksFromTable()
                .titlesOfBooksEquals10();
    }
}