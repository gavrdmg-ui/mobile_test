package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;

public class OnBoardingScreenTests extends TestBase {

    @Test
    void navigateOnBoardScreenTest() {
        step("Прохождение страницы \"All the world's knowledge\"", () -> {
            $(accessibilityId("Wikipedia")).shouldBe(Condition.visible);
            $(accessibilityId("Forward")).click();
        });
        step("Прохождение страницы \"Data and Privacy\"", () -> {
            $(accessibilityId("Data & Privacy")).shouldBe(Condition.visible);
            $(accessibilityId("Forward")).click();
        });
        step("Прохождение страницы \"Read in more than 300 languages\"", () -> {
            $(accessibilityId("Read in more than 300 languages")).shouldBe(Condition.visible);
            $(accessibilityId("Forward")).click();
        });
        step("Прохождение страницы \"Follow your curiosity\"", () -> {
            $x("//android.widget.TextView[@text=\"Skip\"]\n").shouldBe(Condition.visible);
            $x("//android.widget.TextView[@text=\"Skip\"]\n").click();
        });
        step("Проверка что мы на главное старнице", () -> {
            $(accessibilityId("Home")).shouldBe(Condition.selected);
        });
    }
}
