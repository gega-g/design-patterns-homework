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
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomReportListener.class, CustomTestListener.class, CustomSuiteListener.class})

@Epic("Selenide tests 2")
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

    @Description("Checking element attributes in demos design")
    @Feature("demos page")
    @Story("validating background color and selection bar navigates correctly")
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

    @Description("Validating that order prices are displayed correctly")
    @Feature("pricing page")
    @Feature("order page")
    @Feature("contact info page")
    @Story("on price page click on 'Buy devcraft ultimate'")
    @Story("on order page fill the order on 2 years and check if price gets calculated correctly")
    @Story("fill the contact info page fields")
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

    @Description("Getting books of our needs")
    @Feature("books page")
    @Story("printing all javascript books names by O'Reilly Media")
    @Test(description = Constants.CHAINEDDESC)
    public void chainedLocatorsTest() {
        booksPage
                .navigateToBooksPage();
        booksPageSteps
                .printAllJSBooksByMedia();
    }

    @Feature("books page")
    @Story("getting all desired books")
    @Description("Checking if the amount of books equals to 10")
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