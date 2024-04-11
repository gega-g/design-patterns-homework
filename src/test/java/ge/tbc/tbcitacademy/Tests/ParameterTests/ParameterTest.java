package ge.tbc.tbcitacademy.Tests.ParameterTests;

import ge.tbc.tbcitacademy.Tests.Configuration.ConfigTests;
import ge.tbc.tbcitacademy.pages.AutomationPracticeFormPage;
import ge.tbc.tbcitacademy.steps.AutomationPracticeFormPageSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterTest extends ConfigTests {
    AutomationPracticeFormPage autoPage = new AutomationPracticeFormPage();
    AutomationPracticeFormPageSteps autoSteps = new AutomationPracticeFormPageSteps();

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
