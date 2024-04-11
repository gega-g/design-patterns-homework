package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ContactInfoPageSteps {
    WebDriver driver;
    SoftAssert sfa = new SoftAssert();
    ElementsCollection fillable;
    public ContactInfoPageSteps fillDropDown(){
        $(".k-icon.k-i-arrow-s").click();
        $(byText(Constants.AFGHANISTAN)).click();
        return this;
    }

    public ContactInfoPageSteps fillRest(){
        ElementsCollection fillable = $$x("//input[@type='text']");
        for (SelenideElement element : fillable) {
            if (element.getAttribute(Constants.ID).equals(Constants.BIEMAIL)) {
                element.sendKeys(Constants.MAIL);
            } else {
                element.scrollTo();
                element.sendKeys(Constants.FULLNAME);
            }
        }
        return this;
    }

    public ContactInfoPageSteps navigateBackAndForward(){
        driver.navigate().back();
        driver.navigate().forward();
        return this;
    }

    public ContactInfoPageSteps isTextStillFilled(){
        for (SelenideElement element : fillable){
            sfa.assertTrue(element.has(exactText(Constants.FULLNAME)));
        }
        sfa.assertAll();
        return this;
    }
}
