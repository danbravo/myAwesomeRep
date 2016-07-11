package reg;

import core.BrowserFact;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SomeTest extends BrowserFact {

    @Test(description = "some desc info")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Login"})
    @Stories({"Try log as Admin and check access"})
    public void loginUserInAdminka() {
        System.out.println("Login is successful");
        step1LogInOnMainPage("lalala@gmail.com");
        step2CheckResults();
    }

    @Title("Оплата картой ПриватБанк")
    @Test
    @Features({"Payment"})
    @Stories({"Pay by credit card, 3 days plan"})
    public void payByCreditCard() {
        System.out.println("Payment is done");
    }

    @Step("Логин юзера на сайте : {0}")
    public void step1LogInOnMainPage(String email) {
        System.out.println("this is STEP 1");
        txtAttachment("this is user info", email);
    }

    @Attachment(value = "{1}", type = "text/plain")
    public static String txtAttachment(String text, String name) {
        return text;
    }

    @Step
    public void step2CheckResults() {
        System.out.println("this is STEP 2");
    }
}
