package pages;

import core.MethodsFact;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends MethodsFact{
    public Registration reg;
    public LogIn logIn;

    private By regBtn = By.xpath("//div[@class='amount__bot']/a[@href='/register']");
    private By logInBtn = By.xpath("//div[@class='cabinet']/a");

    public MainPage() {
        reg = new Registration();
        logIn = new LogIn();
    }

    @Step("Opening mane page")
    public void openPage() {
        driver.get("https://consiliumcenter.cc/");
    }

    @Step("Proceeding to registration page")
    public void clickRegBtn() {
        driver.findElement(regBtn).click();
    }

    @Step("Proceeding to login page")
    public void clickLogInBtn() {
        click(logInBtn);
    }

    @Attachment(value = "{1}", type = "text/plain")
    public static String txtAttachment(String text, String... name) {
        return text;
    }
}
