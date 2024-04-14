package ge.tbc.tbcitacademy.Tests.SelenideTests;

import ge.tbc.tbcitacademy.Tests.Configuration.ConfigTests;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.listeners.ReportListener.CustomReportListener;
import ge.tbc.tbcitacademy.listeners.SuiteListener.CustomSuiteListener;
import ge.tbc.tbcitacademy.listeners.TestListener.CustomTestListener;
import ge.tbc.tbcitacademy.pages.CheckBoxPage;
import ge.tbc.tbcitacademy.pages.DropDownPage;
import ge.tbc.tbcitacademy.pages.PricingPage;
import ge.tbc.tbcitacademy.pages.TextBoxPage;
import ge.tbc.tbcitacademy.steps.CheckBoxPageSteps;
import ge.tbc.tbcitacademy.steps.DropDownPageSteps;
import ge.tbc.tbcitacademy.steps.PricingPageSteps;
import ge.tbc.tbcitacademy.steps.TextBoxPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomReportListener.class, CustomTestListener.class, CustomSuiteListener.class})

@Epic("Selenide Tests 1")
public class SelenideTests extends ConfigTests {
    PricingPage pricingPage = new PricingPage();
    PricingPageSteps pricingPageSteps = new PricingPageSteps();
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    CheckBoxPageSteps checkBoxPageSteps = new CheckBoxPageSteps();
    DropDownPage dropDownPage = new DropDownPage();
    DropDownPageSteps dropDownPageSteps = new DropDownPageSteps();
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxPageSteps textBoxPageSteps = new TextBoxPageSteps();

    @Description("validating bundle offers")
    @Feature("pricing page")
    @Story("checking if some attributes of elements are present")
    @Test(description = Constants.BUNDLEOFFERSDESC)
    public void validateBundleOffers(){
        pricingPage
                .navigateToPricingPage();
        pricingPageSteps
                .seeDetailedComparison()
                .checkUIHasNoRapidUnitTesting()
                .offerNamesVisible();
    }

    @Description("validating individual offers")
    @Feature("pricing page")
    @Story("ninja appears on hover, prices are correct in checkout")
    @Test(description = Constants.INDIVIDUALOFFERSDESC)
    public void validateIndividualOffers(){
        pricingPage
                .navigateToPricingPage()
                .toIndividualOffersPage();
        pricingPageSteps
                .ninjaAppears()
                .supportTextVisible()
                .priceCheckOnUI()
                .priceCheckOnReact();
    }

    @Description("testing check function in checkboxes")
    @Feature("checkbox page")
    @Story("checking if checkboxes are checked after clicking")
    @Test(description = Constants.CHECKBOXDESC)
    public void checkBoxTest() {
        checkBoxPage
                .navigateToCheckBoxPage();
        checkBoxPageSteps
                .checkBox1ClickAndCheck()
                .checkBox2Check();
    }

    @Description("testing dropdown ability to select correct option")
    @Feature("dropdown page")
    @Story("checking if correct option is selected after clicking")
    @Test(description = Constants.DROPDOWNDESC)
    public void dropDownTest() {
        dropDownPage
                .navigateToDropDownPage();
        dropDownPageSteps
                .isOptionSelected()
                .selectOption2();
    }

    @Description("filling forms")
    @Feature("textbox page")
    @Story("filling form and checking if filled")
    @Test(description = Constants.COLLECTIONSDESC)
    public void collectionsTest() {
        textBoxPage
                .navigateToTextBoxPage();
        textBoxPageSteps
                .fillName()
                .fillEmail()
                .fillCurrentAddress()
                .fillPermanentAddress()
                .checkIfFilled();
    }
}
