package ge.tbc.tbcitacademy.pages;

import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selenide.open;

public class DropDownPage {
    public DropDownPage navigateToDropDownPage(){
        open(Constants.DROPDOWNURL);
        return this;
    }
}
