package ge.tbc.tbcitacademy.pages;

import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormPage {
    public AutomationPracticeFormPage navigateToPracticeFormPage(){
        open(Constants.DEMOQAURLAUTO);
        return this;
    }
}
