package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import screens.components.ConfirmWindow;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static testdata.TestData.emptySearchHistoryMessage;

public class SearchScreen {
    ConfirmWindow confirmWindow = new ConfirmWindow();
    private static final SelenideElement closeWidgetButton = $(accessibilityId("Close"));
    private static final SelenideElement searchField = $(accessibilityId("Search Wikipedia"));
    private static final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private static final ElementsCollection listOfArticles = $$(id("org.wikipedia.alpha:id/fragment_search_results"));
    private static final SelenideElement clearHistoryButton = $(accessibilityId("Clear reading history"));
    private static final SelenideElement backScreenButton = $(accessibilityId("Navigate up"));
    private static final SelenideElement emptyTitleText = $("[resource-id=\"org.wikipedia.alpha:id/history_empty_title\"]");
    private static final SelenideElement savedButton = $(accessibilityId("Saved"));


    @Step("Закрываем всплывающий виджет")
    public SearchScreen closeWidget() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (closeWidgetButton.has(Condition.interactable)) {
            closeWidgetButton.click();
        }
        return this;
    }

    @Step("Нажимаем на строку для ввода поискового запроса")
    public SearchScreen clickOnSearchField() {
        searchField.click();
        return this;
    }

    @Step("Вводим с строку поиска значение {query}")
    public SearchScreen typeSearchQuery(String query) {
        searchInput.sendKeys(query);
        return this;
    }

    @Step("Проверяем что список найденных статей не пустой")
    public SearchScreen articlesListIsNotEmpty() {
        listOfArticles.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открывем статью {query}")
    public SearchScreen openArticle(String query) {
        $x("//android.widget.TextView[@text=\"" + query + "\"]").click();
        return this;
    }

    @Step("Нажимаем на кнопку очистки истории поиска")
    public SearchScreen clearHistory() {
        clearHistoryButton.click();
        return this;
    }

    public SearchScreen confirmClearHistory() {
        confirmWindow.pressConfirm();
        return this;
    }

    @Step("Нажимаем на кнопку \"Назад\" рядом со сторокой поиска")
    public SearchScreen clickBackScreenButton() {
        backScreenButton.click();
        return this;
    }

    @Step("Проверяем что история поиска пустая")
    public SearchScreen historyIsEmpty() {
        emptyTitleText.shouldHave(text(emptySearchHistoryMessage));
        return this;
    }

    @Step("Нажимаем на кнопку \"Saved\"")
    public SearchScreen clickSavedButton() {
        savedButton.click();
        return this;
    }


}
