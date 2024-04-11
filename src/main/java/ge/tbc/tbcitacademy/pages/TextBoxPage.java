package ge.tbc.tbcitacademy.pages;

import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    public TextBoxPage navigateToTextBoxPage(){
        open(Constants.COLLECTIONSURL);
        return this;
    }
}
