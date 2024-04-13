package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxPageSteps {
    private SelenideElement name;
    private SelenideElement email;
    private SelenideElement currentAddress;
    private SelenideElement permanentAddress;

    @Step("fill name field")
    public TextBoxPageSteps fillName() {
        name = $(".mr-sm-2.form-control")
                .shouldHave(attribute(Constants.PLACEHOLDER, Constants.FULLNAME))
                .setValue(Constants.FULLNAME);
        return this;
    }

    @Step("fill email field")
    public TextBoxPageSteps fillEmail() {
        email = $x("//input[@placeholder='name@example.com']")
                .setValue(Constants.MAIL);
        return this;
    }

    @Step("fill current address field")
    public TextBoxPageSteps fillCurrentAddress() {
        currentAddress = $("[class='form-control']")
                .shouldHave(attribute(Constants.PLACEHOLDER, Constants.CURRENTADDRESS))
                .setValue(Constants.CURRENTADDRESS);
        return this;
    }

    @Step("fill permanent address field")
    public TextBoxPageSteps fillPermanentAddress() {
        permanentAddress = $("#permanentAddress")
                .setValue(Constants.PERMANENTADDRESS);
        return this;
    }

    @Step("check if all fields are indeed filled and not empty")
    public TextBoxPageSteps checkIfFilled() {
        List<SelenideElement> inputFields = Arrays.asList(name, email, currentAddress, permanentAddress);
        for (SelenideElement field : inputFields) {
            field.shouldBe(Condition.visible);
        }
        return this;
    }
}
