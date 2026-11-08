package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты начальных экранов")
public class OnBoardingScreenTests extends TestBase {

    @Test
    @DisplayName("Прохождение начальных экранов")
    void navigateOnBoardScreenTest() {
        onBoardScreen.skipFirstOnBoardPage()
                .skipSecondOnBoardPage()
                .skipThirdOnBoardPage()
                .skipFourthOnBoardPage();
        homeScreen.checkHomeScreenIsOpen();
    }
}
