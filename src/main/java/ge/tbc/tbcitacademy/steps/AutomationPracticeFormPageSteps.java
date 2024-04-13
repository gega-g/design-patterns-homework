package ge.tbc.tbcitacademy.steps;

import ge.tbc.tbcitacademy.data.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class AutomationPracticeFormPageSteps {
    @Step("fill first name field")
    public AutomationPracticeFormPageSteps fillFirstname(String firstName){
        $(By.id(Constants.FIRSTNAME)).scrollTo().sendKeys(firstName);
        return this;
    }
    @Step("fill last name field")
    public AutomationPracticeFormPageSteps fillLastname(String lastName){
        $(By.id(Constants.LASTNAME)).scrollTo().sendKeys(lastName);
        return this;
    }

    @Step("choose gender")
    public AutomationPracticeFormPageSteps selectGender(String gender){
        $(By.cssSelector("#genterWrapper input[value='" + gender + "']")).sibling(0).click();
        return this;
    }

    @Step("fill phone number")
    public AutomationPracticeFormPageSteps fillNumber(String mobileNumber){
        $(By.id(Constants.USERNUMBER)).sendKeys(mobileNumber);
        return this;
    }

    @Step("assert first name")
    public AutomationPracticeFormPageSteps isFirstnameCorrect(String firstName){
        String enteredFirstName = $(By.id(Constants.FIRSTNAME)).getValue();
        assertEquals(enteredFirstName, firstName);
        return this;
    }
}
