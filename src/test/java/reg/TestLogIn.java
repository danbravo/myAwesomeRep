package reg;

import core.BrowserFact;
import core.MyFileLogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Listeners({MyFileLogListener.class})
@Features({"Log In"})
@Stories({"Logging and changing basic user info"})
public class TestLogIn extends BrowserFact{

    @Test(priority = 0)
    public void openPage() {
        mainPage.openPage();
    }

    @Test(priority = 1)
    public void pressLogInBtn() {
        mainPage.clickLogInBtn();
    }

    @Parameters({"email"})
    @Test(priority = 2)
    public void typeEmail(@Optional("vasylpet@mail.ru") String email) {
        mainPage.logIn.typeEmail(email);
    }

    @Parameters({"pass"})
    @Test(priority = 3)
    public void typePass(@Optional("2342925dan") String pass) {
        mainPage.logIn.typePass(pass);
    }

    @Test(priority = 4)
    public void clickProceedLogInBtn() {
        mainPage.logIn.clickProceedLogInBtn();
    }

    @Test(priority = 5)
    public void proceedToProfilePage() {
        mainPage.logIn.clickProfilePageBtn();
    }

    @Parameters({"name", "surname", "midname"})
    @Test(priority = 6)
    public void changeNames(@Optional("Dan")String name,
                            @Optional("Bravo")String surname, @Optional("Awesome")String midname) {
        mainPage.logIn.typeNames(name, surname, midname);
    }

    @Parameters({"gender"})
    @Test(priority = 7)
    public void changeGender(@Optional("male")String gender) {
        mainPage.logIn.chooseGender(gender);
    }

    @Parameters({"date"})
    @Test(priority = 8)
    public void changeDate(String date) {
        mainPage.logIn.clickCalendar();
        mainPage.logIn.chooseDate(date);
    }

    @Test(priority = 9)
    public void clickSaveBtn() {
        mainPage.logIn.clickSaveBtn();
        mainPage.logIn.clickProceedSaveBtn();
    }

}
