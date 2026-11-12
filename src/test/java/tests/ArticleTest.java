package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты функционала статей ")
public class ArticleTest extends TestBase {
    @Test
    @DisplayName("Добавление статье в сохраненные")
    void saveArticle() {
        onBoardScreen.skipOnBoarding();
        homeScreen.clickOnSearchButton();
        searchScreen.closeWidget()
                .clickOnSearchField()
                .typeSearchQuery(testData.articleName)
                .articlesListIsNotEmpty()
                .openArticle(testData.articleName);
        articleScreen.articleHasText(testData.articleName)
                .clickSaveButton()
                .clickBackPhoneButton()
                .clickBackPhoneButton();
        searchScreen.clickBackScreenButton()
                .clickSavedButton();
        savedArticles.isArticleExist(testData.articleName);
    }

    @Test
    @DisplayName("Удаление статье из сохраненных")
    void deleteArticleFromSaved() {
        onBoardScreen.skipOnBoarding();
        homeScreen.clickOnSearchButton();
        searchScreen.closeWidget()
                .clickOnSearchField()
                .typeSearchQuery(testData.articleName)
                .articlesListIsNotEmpty()
                .openArticle(testData.articleName);
        articleScreen.articleHasText(testData.articleName)
                .clickSaveButton()
                .clickBackPhoneButton()
                .clickBackPhoneButton();
        searchScreen.clickBackScreenButton()
                .clickSavedButton();
        savedArticles.isArticleExist(testData.articleName)
                .openArticle(testData.articleName);
        articleScreen.clickSaveButton()
                .clickSavedButton()
                .clickBackPhoneButton();
        savedArticles.articleWithTitleNotExist(testData.articleName);
    }
}
