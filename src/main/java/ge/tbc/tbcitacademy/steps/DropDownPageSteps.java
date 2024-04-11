package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DropDownPageSteps {
    SelenideElement dropdown = $("#dropdown");

    public DropDownPageSteps isOptionSelected(){
        dropdown.click();
        SelenideElement option = $x("//option[text()='Please select an option']");
        option.shouldBe(selected);
        return this;
    }

    public DropDownPageSteps selectOption2(){
        dropdown.selectOption(Constants.OPT2);
        dropdown.getSelectedOption().shouldHave(text(Constants.OPT2), value(Constants.TWO));
        return this;
    }
}
