package ge.tbc.tbcitacademy.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GetPricesFromStrings {
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
