package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPageSteps {

    @Step("Assert if unit price equals total price")
    public OrderPageSteps UnitPriceEqualsTotalPrice(){
        Assert.assertEquals(getUnitPrice(), getTotalPrice());
        return this;
    }

    @Step("set quantity on two")
    public OrderPageSteps setQuantityOnTwo(){
        $("span.k-input").click();
        $(byText(Constants.TWO)).click();
        return this;
    }

    @Step("Assert that expected price equals total price after discount")
    public OrderPageSteps isExpectedTotalPriceCorrect(){
        $x("//div[contains(text(), 'Save')]").shouldBe(visible);
        double totalPriceAfterDiscount = getTotalPrice();
        double expectedTotalPrice = getUnitPrice() * 2;
        Assert.assertEquals(expectedTotalPrice, totalPriceAfterDiscount);
        return this;
    }

    @Step("Assert that discount percentage is written correctly on element hover")
    public OrderPageSteps isDiscountCorrectOnHover(){
        double discountNotOnHover = getDiscountAmounts($(".u-fr.e2e-total-discounts-price"));
        $("[class='far fa-question-circle tooltip-icon']").hover();
        double discountOnHover = getDiscountAmounts($(".u-pr5.e2e-licenses-discounts"));
        Assert.assertEquals(discountOnHover,discountNotOnHover);
        return this;
    }

    @Step("click on continue")
    public void clickOnContinue(){
        $(".btn-content.ng-star-inserted").scrollTo().click();
    }

    public double getTotalPrice() {
        String tp = $(".u-fr.e2e-total-price").getText();
        return Double.parseDouble(tp
                .replace("$", "")
                .replace(",", "")
                .replace("US ", ""));
    }

    public double getUnitPrice() {
        String up = $("span.e2e-price-per-license.ng-star-inserted").getText();
        return Double.parseDouble(up
                .replace("$", "")
                .replace(",", ""));
    }
    public double getDiscountAmounts(SelenideElement element){
        String text = element.getText();
        return Double.parseDouble(text
                .replace("$", "")
                .replace("-", "")
                .replace(",", ""));
    }
}
