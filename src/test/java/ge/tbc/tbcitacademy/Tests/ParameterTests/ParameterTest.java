package ge.tbc.tbcitacademy.Tests.ParameterTests;

import ge.tbc.tbcitacademy.Tests.Configuration.ConfigTests;
import ge.tbc.tbcitacademy.pages.AutomationPracticeFormPage;
import ge.tbc.tbcitacademy.steps.AutomationPracticeFormPageSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Parameter test")
public class ParameterTest extends ConfigTests {
    AutomationPracticeFormPage autoPage = new AutomationPracticeFormPage();
    AutomationPracticeFormPageSteps autoSteps = new AutomationPracticeFormPageSteps();

    @Feature("auto page")
    @Story("using dataprovider and filling form")
    @Test(dataProvider = "userData", dataProviderClass = ge.tbc.tbcitacademy.dataProvider.DataProvider.class)
    public void parameterTest(String firstName, String lastName, String gender, String mobileNumber) {
        autoPage
                .navigateToPracticeFormPage();
        autoSteps
                .fillFirstname(firstName)
                .fillLastname(lastName)
                .selectGender(gender)
                .fillNumber(mobileNumber)
                .isFirstnameCorrect(firstName);
    }
}
