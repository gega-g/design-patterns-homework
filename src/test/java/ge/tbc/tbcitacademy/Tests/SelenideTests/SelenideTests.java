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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomReportListener.class, CustomTestListener.class, CustomSuiteListener.class})

public class SelenideTests extends ConfigTests {
    PricingPage pricingPage = new PricingPage();
    PricingPageSteps pricingPageSteps = new PricingPageSteps();
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    CheckBoxPageSteps checkBoxPageSteps = new CheckBoxPageSteps();
    DropDownPage dropDownPage = new DropDownPage();
    DropDownPageSteps dropDownPageSteps = new DropDownPageSteps();
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxPageSteps textBoxPageSteps = new TextBoxPageSteps();


    @Test(description = Constants.BUNDLEOFFERSDESC)
    public void validateBundleOffers(){
        pricingPage
                .navigateToPricingPage();
        pricingPageSteps
                .seeDetailedComparison()
                .checkUIHasNoRapidUnitTesting()
                .offerNamesVisible();
    }

    @Test(description = Constants.INDIVIDUALOFFERSDESC)
    public void validateIndividualOffers(){
        pricingPage
                .navigateToPricingPage()
                .toIndividualOffersPage();
        pricingPageSteps
                .ninjaAppears()
                .supportTextVisible()
                .priceCheck();
    }

    @Test(description = Constants.CHECKBOXDESC)
    public void checkBoxTest() {
        checkBoxPage
                .navigateToCheckBoxPage();
        checkBoxPageSteps
                .checkBox1ClickAndCheck()
                .checkBox2Check();
    }

    @Test(description = Constants.DROPDOWNDESC)
    public void dropDownTest() {
        dropDownPage
                .navigateToDropDownPage();
        dropDownPageSteps
                .isOptionSelected()
                .selectOption2();
    }

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
