package ge.tbc.tbcitacademy.steps;

import ge.tbc.tbcitacademy.data.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class AutomationPracticeFormPageSteps {
    public AutomationPracticeFormPageSteps fillFirstname(String firstName){
        $(By.id(Constants.FIRSTNAME)).scrollTo().sendKeys(firstName);
        return this;
    }
    public AutomationPracticeFormPageSteps fillLastname(String lastName){
        $(By.id(Constants.LASTNAME)).scrollTo().sendKeys(lastName);
        return this;
    }

    public AutomationPracticeFormPageSteps selectGender(String gender){
        $(By.cssSelector("#genterWrapper input[value='" + gender + "']")).sibling(0).click();
        return this;
    }

    public AutomationPracticeFormPageSteps fillNumber(String mobileNumber){
        $(By.id(Constants.USERNUMBER)).sendKeys(mobileNumber);
        return this;
    }

    public AutomationPracticeFormPageSteps isFirstnameCorrect(String firstName){
        String enteredFirstName = $(By.id(Constants.FIRSTNAME)).getValue();
        assertEquals(enteredFirstName, firstName);
        return this;
    }
}
