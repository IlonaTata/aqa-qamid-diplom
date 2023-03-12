import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement successfulPayment = $("notification notification_visible notification_status_ok" +
            " notification_has-closer notification_stick-to_right notification_theme_alfa-on-white");
    private SelenideElement invalidPayment = $("notification notification_visible notification_status_error" +
            " notification_has-closer notification_stick-to_right notification_theme_alfa-on-white");

    public void VerificationPageSuccess() {

        successfulPayment.shouldBe(visible);
    }
    public void VerificationPageInvalid() {

        invalidPayment.shouldBe(visible);
    }

}

