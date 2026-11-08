package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class OnBoardScreen {
    private static final SelenideElement firstOnBoardPage = $(accessibilityId("Wikipedia"));
    private static final SelenideElement secondOnBoardPage = $(accessibilityId("Data & Privacy"));
    private static final SelenideElement thirdOnBoardPage = $(accessibilityId("Read in more than 300 languages"));
    private static final SelenideElement fourthOnBoardPage = $(accessibilityId("Follow your curiosity"));
    private static final SelenideElement forwardButton = $(accessibilityId("Forward"));
    private static final SelenideElement skipButton = $x("//android.widget.TextView[@text=\"Skip\"]\n");

    @Step("Прохождение страницы \"All the world's knowledge\"")
    public OnBoardScreen skipFirstOnBoardPage() {
        firstOnBoardPage.shouldBe(Condition.visible);
        forwardButton.click();
        return this;
    }

    @Step("Прохождение страницы \"Data and Privacy\"")
    public OnBoardScreen skipSecondOnBoardPage() {
        secondOnBoardPage.shouldBe(Condition.visible);
        forwardButton.click();
        return this;
    }

    @Step("Прохождение страницы \"Read in more than 300 languages\"")
    public OnBoardScreen skipThirdOnBoardPage() {
        thirdOnBoardPage.shouldBe(Condition.visible);
        forwardButton.click();
        return this;
    }

    @Step("Прохождение страницы \"Follow your curiosity\"")
    public OnBoardScreen skipFourthOnBoardPage() {
        fourthOnBoardPage.shouldBe(Condition.visible);
        skipButton.click();
        return this;
    }

    @Step("Нажимаем кноку \"Назад\" на телефоне")
    public OnBoardScreen skipOnBoarding() {
        back();
        return this;
    }

}
