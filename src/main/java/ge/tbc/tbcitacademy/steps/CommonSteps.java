package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CommonSteps {

    @Step("Accept cookies")
    public CommonSteps acceptCookies(){
        SelenideElement cookies = $(byId(Constants.ONETRUST));
        cookies.click();
        return this;
    }
}
