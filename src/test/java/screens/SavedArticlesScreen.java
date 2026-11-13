package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SavedArticlesScreen {

    @Step("Проверяем что на странице есть сохраненная статья {article}")
    public SavedArticlesScreen isArticleExist(String article) {
        $x("//*[contains(@text, '" + article + "')]").shouldHave(text(article));
        return this;
    }
    @Step("Открываем сохраненную статью {article}")
    public SavedArticlesScreen openArticle(String article) {
        $x("//*[contains(@text, '" + article + "')]").click();
        return this;
    }
    @Step("Проверяем что на странице нет сохраненной статьи {article}")
    public SavedArticlesScreen articleWithTitleNotExist(String article) {
        assertFalse($x("//*[contains(@text, '" + article + "')]").exists());
        return this;
    }
}
