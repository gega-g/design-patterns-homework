package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;

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

    public TextBoxPageSteps fillName() {
        name = $(".mr-sm-2.form-control")
                .shouldHave(attribute(Constants.PLACEHOLDER, Constants.FULLNAME))
                .setValue(Constants.FULLNAME);
        return this;
    }

    public TextBoxPageSteps fillEmail() {
        email = $x("//input[@placeholder='name@example.com']")
                .setValue(Constants.MAIL);
        return this;
    }

    public TextBoxPageSteps fillCurrentAddress() {
        currentAddress = $("[class='form-control']")
                .shouldHave(attribute(Constants.PLACEHOLDER, Constants.CURRENTADDRESS))
                .setValue(Constants.CURRENTADDRESS);
        return this;
    }

    public TextBoxPageSteps fillPermanentAddress() {
        permanentAddress = $("#permanentAddress")
                .setValue(Constants.PERMANENTADDRESS);
        return this;
    }

    public TextBoxPageSteps checkIfFilled() {
        List<SelenideElement> inputFields = Arrays.asList(name, email, currentAddress, permanentAddress);
        for (SelenideElement field : inputFields) {
            field.shouldBe(Condition.visible);
        }
        return this;
    }
}
