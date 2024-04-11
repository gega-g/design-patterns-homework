package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CommonSteps {
    public CommonSteps acceptCookies(){
        SelenideElement cookies = $(byId(Constants.ONETRUST));
        cookies.click();
        return this;
    }
}
