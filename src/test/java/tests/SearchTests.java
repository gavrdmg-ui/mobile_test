package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты поиска статей")
public class SearchTests extends TestBase {
    @Test
    @DisplayName("Поиск статьи")
    void successfulSearchTest() {
        onBoardScreen.skipOnBoarding();
        homeScreen.clickOnSearchButton();
        searchScreen.closeWidget()
                .clickOnSearchField()
                .typeSearchQuery(testData.articleName)
                .articlesListIsNotEmpty();
    }

    @Test
    @DisplayName("Переход в найденную статью")
    void openArticleTest() {
        onBoardScreen.skipOnBoarding();
        homeScreen.clickOnSearchButton();
        searchScreen.closeWidget()
                .clickOnSearchField()
                .typeSearchQuery(testData.articleName)
                .articlesListIsNotEmpty()
                .openArticle(testData.articleName);
        articleScreen.articleHasText(testData.articleName);
    }

    @Test
    @DisplayName("Очистка истории поиска")
    void clearSearchHistory() {
        onBoardScreen.skipOnBoarding();
        homeScreen.clickOnSearchButton();
        searchScreen.closeWidget()
                .clickOnSearchField()
                .typeSearchQuery(testData.articleName)
                .articlesListIsNotEmpty()
                .openArticle(testData.articleName);
        articleScreen.articleHasText(testData.articleName)
                .clickBackPhoneButton();
        searchScreen.clickBackScreenButton()
                .clearHistory()
                .confirmClearHistory()
                .historyIsEmpty();


    }
}