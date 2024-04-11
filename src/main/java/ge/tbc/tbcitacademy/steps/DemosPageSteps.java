package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class DemosPageSteps {
    SoftAssert sfa;
    public DemosPageSteps validateColorAndTextForWeb(){
        ElementsCollection webPics = $$x("//h2[@id='web']/following:" +
                ":div[@class='HoverImg u-mb1'][following::h2[@id='desktop']]");
        for (SelenideElement pic : webPics) {
            actions().moveToElement(pic).perform();
            sfa.assertTrue(pic.has(attribute(Constants.CLASS, Constants.PURPLE)), Constants.HOVERERRORMESSAGE);
        }
        sfa.assertTrue(webPics.get(0).hover().innerHtml().contains(Constants.UICONDITION), Constants.UIERROR);
        return this;
    }

    public DemosPageSteps microsoftButtonOnDesktopElement(){
        ElementsCollection desktopElements = $$x("//h2[@id='desktop']/following:" +
                ":div[contains(@data-placeholder-label, 'Column')][following::h2[@id='mobile']]");
        for (SelenideElement element : desktopElements) {
            if (element.innerHtml().contains(Constants.MICROSOFT)) {
                System.out.println(element.find(".h4").getText() + Constants.WITHMICROSOFT);
            }
        }
        return this;
    }

    public DemosPageSteps xamarinValidations(){
        SelenideElement xamarin = $(By.id(Constants.XAMARINID));
        Assert.assertTrue(
                xamarin.innerHtml().contains(Constants.MICROSOFT2) &&
                        xamarin.innerHtml().contains(Constants.APPLE) &&
                        xamarin.innerHtml().contains(Constants.GOOGLE));
        return this;
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
