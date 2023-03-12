import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static SelenideElement cardNumber = $("[placeholder=\"0000 0000 0000 0000\"]");
    private static SelenideElement mouthField = $("[placeholder=\"08\"]");
    private static SelenideElement yearField = $(" [placeholder=\"22\"]");
    public static SelenideElement nameButton = $("div:nth-child(3) span:nth-child(1) span.input__box input");
    private static SelenideElement cvcCvv = $("[placeholder=\"999\"]");
    private static SelenideElement continueButton = $(Selectors.withText("Продолжить"));
    private static SelenideElement pay  =
        $(Selectors.withText("Купить"));

    private static SelenideElement credit =
            $(Selectors.withText("Купить в кредит"));
    private static SelenideElement successfulPayment = $(Selectors.withText("Успешно"));
    private static SelenideElement errorPayment = $(Selectors.withText("Ошибка"));

    private static SelenideElement errorCard = $(Selectors.withText("Неверный формат"));

    private static SelenideElement errorMonth = $(Selectors.withText("Неверный формат"));
    private static SelenideElement errorMonth1 = $(Selectors.withText("Неверно указан срок действия карты"));
    private static SelenideElement errorYear = $(Selectors.withText("Истёк срок действия карты"));
    private static SelenideElement errorYear1 = $(Selectors.withText("Неверный формат"));
    private static SelenideElement emptyName = $(Selectors.withText("Поле обязательно для заполнения"));
    private static SelenideElement errorCvc = $(Selectors.withText("Неверный формат"));
    public static VerificationPage validLogin(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateValidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue(DataHelper.generateRandomName());
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        successfulPayment.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage inValidLogin(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue("123456789123");
        mouthField.setValue(String.valueOf(DataHelper.generateValidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue(DataHelper.generateRandomName());
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        errorCard.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage inValidMonth(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateInvalidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue(DataHelper.generateRandomName());
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        errorMonth.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage notExistMonth(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateNotExistMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue(DataHelper.generateRandomName());
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        errorMonth1.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage invalidYear(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateValidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateInvalidRandomYear()));
        nameButton.setValue(DataHelper.generateRandomName());
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        errorYear.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage emptyPage(DataHelper.AuthInfo info) {
        pay.click();
        continueButton.click();
        errorCard.shouldBe((visible), Duration.ofSeconds(15));
        errorMonth.shouldBe((visible), Duration.ofSeconds(15));
        errorYear1.shouldBe((visible), Duration.ofSeconds(15));
        emptyName.shouldBe((visible), Duration.ofSeconds(15));
        errorCvc.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage russianName(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateValidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue("Иван");
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        errorPayment.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage nameWithSymbol(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateValidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue("12345");
        cvcCvv.setValue(String.valueOf(DataHelper.generateValidCode()));
        continueButton.click();
        errorPayment.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
    public static VerificationPage cvcWith2Symbol(DataHelper.AuthInfo info) {
        pay.click();
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardNumber()));
        mouthField.setValue(String.valueOf(DataHelper.generateValidMonth()));
        yearField.setValue(String.valueOf(DataHelper.generateRandomYear()));
        nameButton.setValue("12345");
        cvcCvv.setValue("12");
        continueButton.click();
        errorCvc.shouldBe((visible), Duration.ofSeconds(15));
        return new VerificationPage();
    }
}

