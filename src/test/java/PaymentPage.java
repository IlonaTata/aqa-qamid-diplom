import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {



    public PaymentPage () {

        SelenideElement heading = $("h3");
        heading.shouldBe(visible);

    }
}


