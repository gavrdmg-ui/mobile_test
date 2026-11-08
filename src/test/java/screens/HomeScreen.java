package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class HomeScreen {
    private static final SelenideElement homePageButton = $(accessibilityId("Home"));
    private static final SelenideElement searchButton = $(accessibilityId("Search"));

    @Step("Проверка что мы на главное старнице")
    public HomeScreen checkHomeScreenIsOpen() {
        homePageButton.shouldBe(Condition.selected);
        return this;
    }

    @Step("Переход на экран поиска")
    public HomeScreen clickOnSearchButton() {
        searchButton.click();
        return this;
    }


}
