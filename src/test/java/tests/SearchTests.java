package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        step("Поиск статьи Appium", () -> {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.accessibilityId("Search Wikipedia"))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    id("org.wikipedia.alpha:id/search_src_text"))).sendKeys("Dog");
        });
        step("Проверка что результат поиска не пустой", () -> {
            List<WebElement> titles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    id("org.wikipedia.alpha:id/page_list_item_title")));
            assertFalse(titles.isEmpty());
        });
    }

    @Test
    void openArticleTest() {
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        step("Поиск статьи Appium", () -> {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.accessibilityId("Search Wikipedia"))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    id("org.wikipedia.alpha:id/search_src_text"))).sendKeys("Appium");
        });
        step("Проверка что результат поиска не пустой", () -> {
            List<WebElement> titles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    id("org.wikipedia.alpha:id/page_list_item_title")));
            assertFalse(titles.isEmpty());
        });
        step("Открытие статьи", () -> {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))).click();
        });
        step("Проверка заголовка страницы", () -> {
            driver.findElements(
                    AppiumBy.xpath("//*[contains(@text, 'Appium')]"));
        });

    }
}