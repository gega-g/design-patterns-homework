package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PricingPageSteps {

    @Step("click on see detailed comparison")
    public PricingPageSteps seeDetailedComparison() {
        SelenideElement details = $x("//span[@class='action']");
        executeJavaScript("arguments[0].scrollIntoView({block: 'center'});", details);
        details.click();
        return this;
    }

    @Step("check if UI has no rapid unit testing")
    public PricingPageSteps checkUIHasNoRapidUnitTesting(){
        SelenideElement UI = $(".UI.is-active");
        UI.shouldNotHave(text(Constants.MOCKINGSOLUTION));
        return this;
    }

    @Step("check that every offer name is visible")
    public PricingPageSteps offerNamesVisible(){
        ElementsCollection offerNames = $$(".Text--b9.u-fs24.u-tac.u-mb0.js-product");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        for (SelenideElement name : offerNames) {
            name.shouldBe(visible);
        }
        return this;
    }

    @Step("Assert that ninja appears on hover")
    public PricingPageSteps ninjaAppears(){
        $x("//div[@data-opti-expid='KendoReact']").hover();
        Assert.assertTrue($x("//div[@class='Box-ninja u-pt1 u-l-dn']").isDisplayed());
        return this;
    }

    @Step("check that priority support text is visible in elements")
    public PricingPageSteps supportTextVisible(){
        $x("//a[@href='/kendo-ui']/preceding-sibling::div[@data-tlrk-plugin='dropdown']")
                .shouldHave(text(Constants.PRIORITYSUPPORT), visible);
        $x("//a[@href='/kendo-react-ui/#pricing']/preceding-sibling::div[@data-tlrk-plugin='dropdown']")
                .shouldHave(text(Constants.PRIORITYSUPPORT), visible);
        return this;
    }

    @Step("Assert that prices are correct in KendoUI")
    public PricingPageSteps priceCheckOnUI(){
        SelenideElement kendoUI = $x("//div[@data-opti-expid='Kendo UI']");
        Assert.assertEquals(kendoUI.$((".js-price")).text(), Constants.UIPRICE);
        return this;
    }

    @Step("Assert that prices are correct in KendoReact")
    public PricingPageSteps priceCheckOnReact(){
        SelenideElement kendoReact = $x("//div[@data-opti-expid='KendoReact']");
        Assert.assertEquals(kendoReact.$((".js-price")).text(), Constants.REACTPRICE);
        return this;
    }

    @Step("click on Buy DevCraft Ultimate")
    public PricingPageSteps buyDevCraftUltimate(){
        $x("//th[@class='Complete']//a[contains(text(), 'Buy now')]").click();
        $(".far.fa-times.label.u-cp").click();
        return this;
    }
}