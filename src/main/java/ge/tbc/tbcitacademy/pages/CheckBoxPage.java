package ge.tbc.tbcitacademy.pages;

import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selenide.open;

public class CheckBoxPage {
    public CheckBoxPage navigateToCheckBoxPage() {
        open(Constants.CHECKBOXURL);
        return this;
    }
}
