import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class PayTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");}

        @Test
        @DisplayName("Should successfully payment with card")
        void shouldValidLogin () {
            open("http://localhost:8080");
            LoginPage.validLogin(DataHelper.getAuthInfo());
        }

        @Test
        @DisplayName("Should error with wrong card")
        void shouldInvalidLogin () {
            open("http://localhost:8080");
            LoginPage.inValidLogin(DataHelper.getAuthInfo());
        }

        @Test
        @DisplayName("Should error with wrong month")
        void shouldInvalidMonth () {
            open("http://localhost:8080");
            LoginPage.inValidMonth(DataHelper.getAuthInfo());
        }

        @Test
        @DisplayName("Should error with not exist month")
        void shouldNotExistMonth () {
            open("http://localhost:8080");
            LoginPage.notExistMonth(DataHelper.getAuthInfo());
        }

        @Test
        @DisplayName("Should error with wrong year")
        void shouldInvalidYear () {
            open("http://localhost:8080");
            LoginPage.invalidYear(DataHelper.getAuthInfo());
        }


        @Test
        @DisplayName("Should error with empty page")
        void shouldEmptyPage () {
            open("http://localhost:8080");
            LoginPage.emptyPage(DataHelper.getAuthInfo());
        }
        @Test
        @DisplayName("Should error with russian name")
        void shouldRussianName () {
            open("http://localhost:8080");
            LoginPage.russianName(DataHelper.getAuthInfo());
        }
        @Test
        @DisplayName("Should error with symbol name")
        void shouldSymbolName () {
            open("http://localhost:8080");
            LoginPage.nameWithSymbol(DataHelper.getAuthInfo());
        }
        @Test
        @DisplayName("Should error with 2 symbol cvc")
        void shouldWrongCvc () {
            open("http://localhost:8080");
            LoginPage.cvcWith2Symbol(DataHelper.getAuthInfo());
        }
    }