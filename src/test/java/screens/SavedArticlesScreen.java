package screens;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SavedArticlesScreen {

    public SavedArticlesScreen isArticleExist(String article) {
        $x("//*[contains(@text, '" + article + "')]").shouldHave(text(article));
        return this;
    }

    public SavedArticlesScreen openArticle(String article) {
        $x("//*[contains(@text, '" + article + "')]").click();
        return this;
    }

    public SavedArticlesScreen articleWithTitleNotExist(String article) {
        assertFalse($x("//*[contains(@text, '" + article + "')]").exists());
        return this;
    }
}
