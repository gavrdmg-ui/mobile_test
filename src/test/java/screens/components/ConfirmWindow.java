package screens.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmWindow {
    private static final SelenideElement confirmButton = $("[text=\"Yes\"]");

    @Step("Нажимаем на кнопку \"Да\" в открывшемся окне")
    public void pressConfirm() {
        confirmButton.click();
    }
}
