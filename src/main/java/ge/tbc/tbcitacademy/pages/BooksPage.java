package ge.tbc.tbcitacademy.pages;

import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selenide.open;

public class BooksPage {
    public BooksPage navigateToBooksPage(){
        open(Constants.DEMOQAURL);
        return this;
    }
}
