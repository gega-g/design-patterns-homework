package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$;

public class CheckBoxPageSteps {
    ElementsCollection checkboxes = $("#checkboxes").findAll("input[type='checkbox']");

    public CheckBoxPageSteps checkBox1ClickAndCheck(){
        SelenideElement checkbox1 = checkboxes.get(0);
        checkbox1.click();
        checkbox1.shouldBe(checked);
        checkbox1.shouldHave(attribute(Constants.TYPE, Constants.CHECKBOX));
        return this;
    }

    public CheckBoxPageSteps checkBox2Check(){
        SelenideElement checkbox2 = checkboxes.get(1);
        checkbox2.shouldHave(attribute(Constants.TYPE, Constants.CHECKBOX));
        return this;
    }
}
