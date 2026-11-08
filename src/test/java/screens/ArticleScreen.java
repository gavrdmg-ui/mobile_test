package screens;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class ArticleScreen {

    private final static SelenideElement saveButton = $(accessibilityId("Save"));

    @Step("Проверяем что статья содержит текст {text}")
    public ArticleScreen articleHasText(String text) {
        $x("//*[contains(@text, '" + text + "')]").shouldHave(text(text));
        return this;
    }

    @Step("Нажимаем кноку \"Назад\" на телефоне")
    public ArticleScreen clickBackPhoneButton() {
        back();
        return this;
    }

    public ArticleScreen clickSaveButton() {
        saveButton.click();
        return this;
    }


}
