package tests.browserstack;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Test
    void successfulSearchTest() {
        back();
        step("Open search screen", () -> {
            $(accessibilityId("Search")).click();
            Thread.sleep(1000);
            if ($(accessibilityId("Close")).has(Condition.visible)) {
                $(accessibilityId("Close")).click();
            }
        });
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/fragment_search_results"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void openArticleTest() {
        back();
        step("Открытие страница с поиском", () -> {
            $(accessibilityId("Search")).click();
            Thread.sleep(1000);
            if ($(accessibilityId("Close")).has(Condition.visible)) {
                $(accessibilityId("Close")).click();
            }
        });
        step("Ввод поискового запроса", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка что список статей не пустой", () -> {
            $$(id("org.wikipedia.alpha:id/fragment_search_results"))
                    .shouldHave(sizeGreaterThan(0));
        });
        step("Переход в статью", () -> {
            $x("//android.widget.TextView[@text=\"Appium\"]").click();
        });
        step("Проверка заголовка страницы", () -> {
            AppiumBy.xpath("//*[contains(@text, 'Appium')]");
        });


    }
}