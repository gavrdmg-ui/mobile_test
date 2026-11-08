package screens;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.back;

public class ArticleScreen {

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


}
