package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPageSteps {
    SoftAssert sfa = new SoftAssert();
    ElementsCollection books;
    List<SelenideElement> correctBooks = new ArrayList<>();

    public BooksPageSteps JSBooksByMedia() {
        ElementsCollection booksRow = $$(".rt-tr-group");

        for (SelenideElement bookRow : booksRow) {
            String title = bookRow.$(".rt-td:nth-child(2)").text();
            String publisher = bookRow.$(".rt-td:nth-child(4)").text();

            if (title.contains(Constants.JS) && publisher.equals(Constants.MEDIA)) {
                sfa.assertTrue(bookRow.$(".rt-td:nth-child(1)").isDisplayed());
                System.out.println(title);
            }
        }
        return this;
    }

    public BooksPageSteps findAllBooksFromTable(){
        SelenideElement table = $(".rt-table").find(".rt-tbody");
        books = table
                .findAll(By.xpath(".//div[contains(@class, 'rt-tr') " +
                        "and not(contains(@class, '-odd')) " +
                        "and not(contains(@class, '-even'))]"));
        return this;
    }

    public BooksPageSteps correctBooksFromTable(){
        for (SelenideElement book:books){
            String title = book.find(".rt-td:nth-child(2)").getText();
            String publisher = book.find(".rt-td:nth-child(4)").getText();
            if (title.contains(Constants.JS) && publisher.equals(Constants.MEDIA)) {
                correctBooks.add(book);
            }
        }
        return this;
    }

    public BooksPageSteps titlesOfBooksEquals10(){
        List<String> bookTitles = new ArrayList<>();
        for (SelenideElement book : correctBooks) {
            String title = book.find(".rt-td:nth-child(2)").getText();
            bookTitles.add(title);
        }
        sfa.assertEquals(correctBooks.size(), 10);
        sfa.assertEquals(Constants.TITLETOEQUAL, bookTitles.get(0));
        sfa.assertAll();
        return this;
    }
}
