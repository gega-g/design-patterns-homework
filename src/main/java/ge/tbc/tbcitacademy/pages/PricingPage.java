package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PricingPage {

    public PricingPage navigateToPricingPage(){
        open(Constants.TELERIKURL);
        SelenideElement pricing = $(withText(Constants.PRICING));
        pricing.click();
        return this;
    }

    public PricingPage toIndividualOffersPage(){
        $(withText(Constants.INDIVIDUALPRODUCTS)).click();
        return this;
    }
}