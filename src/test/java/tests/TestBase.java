package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.DriverFactory;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.*;
import testdata.TestData;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    OnBoardScreen onBoardScreen = new OnBoardScreen();
    HomeScreen homeScreen = new HomeScreen();
    SearchScreen searchScreen = new SearchScreen();
    ArticleScreen articleScreen = new ArticleScreen();
    public static TestData testData = new TestData();
    SavedArticlesScreen savedArticles = new SavedArticlesScreen();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = new DriverFactory().getDriver();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(false).savePageSource(false));
        open();
    }

    @AfterEach
    void addAttachments() {
        if (Objects.equals(System.getProperty("deviceHost"), "browserstack")) {
            String sessionId = null;
            try {
                sessionId = Selenide.sessionId().toString();
                System.out.println(sessionId);
            } catch (Exception ignored) {
            }
            closeWebDriver();
            if (sessionId != null) {
                try {
                    Attach.addVideo(sessionId);
                } catch (Exception ignored) {
                }
            }
        } else {
            Attach.screenshot();
            Attach.pageSource();
            closeWebDriver();
        }
    }
}