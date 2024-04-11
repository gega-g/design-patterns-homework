package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class DemosPage {
    public DemosPage navigateToDemosPage(){
        open(Constants.TELERIKURL);
        return this;
    }

    public DemosPage navigateToWeb(){
        SelenideElement web = $(byAttribute(Constants.HREF, Constants.WEB));
        web.click();
        return this;
    }

    public DemosPage navigateToDesktop(){
        SelenideElement desktop = $(byAttribute(Constants.HREF, Constants.DESKTOP));
        desktop.click();
        return this;
    }

    public DemosPage navigateToMobile(){
        SelenideElement mobile = $(byAttribute(Constants.HREF, Constants.MOBILE));
        mobile.click();
        return this;
    }

    public DemosPage selectionBarIsSticky(){
        SelenideElement selectionBar = $x("//nav[@data-tlrk-plugin='fixit']");
        Assert.assertTrue(selectionBar.isDisplayed());
        return this;
    }

    public DemosPage selectionBarNavigatesToCorrectElement(){
        ElementsCollection elementsOnSelectionBar = $$(".NavAlt-anchor.u-b0");
        for (SelenideElement element : elementsOnSelectionBar) {
            element.click();
            ElementsCollection h2Elements = $$("h2");

            for (int i = 1; i < h2Elements.size(); i++) {
                String h2 = h2Elements.get(i).getText();

                if (h2.equals(element.getText())) {
                    Assert.assertEquals(h2, element.getText());
                    break;
                }
            }
        }
        return this;
    }
}
