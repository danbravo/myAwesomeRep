package reg;

import core.BrowserFact;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestReg extends BrowserFact {

    @Test(groups = {"createAccount"}, priority = 0)
    public void openPage() {
        mainPage.openPage();
    }

    @Test(groups = {"createAccount"}, priority = 1)
    public void clickRegBtn() {
        mainPage.clickRegBtn();
    }

    @Parameters({"option"})
    @Test(groups = {"createAccount"}, priority = 2)
    public void chooseRegOption(@Optional("pat") String option) {
        mainPage.reg.chooseRegOption(option);
    }

    @Parameters({"newEmail"})
    @Test(groups = {"createAccount"}, priority = 3)
    public void typeEmail(@Optional("TestMail4@gmail.com") String email) {
        mainPage.reg.typeEmail(email);
    }

    @Parameters({"newPass"})
    @Test(groups = {"createAccount"}, priority = 4)
    public void typePass(@Optional("testPASS234") String pass) {
        mainPage.reg.typePass(pass);
    }

    @Test(groups = {"createAccount"}, priority = 5)
    public void clickOffer() {
        mainPage.reg.clickOffer();
    }

    @Test(groups = {"createAccount"}, priority = 6)
    public void clickFinishRegBtn() {
        mainPage.reg.clickFinishRegBtn();
    }

    @Parameters({"name", "surname", "middlename"})
    @Test(groups = {"fillAccount"}, priority = 7)
    public void typeNames(@Optional("Вадим") String name,
                          @Optional("Вадимович") String surname, @Optional("Вадимов")String middlename) {
        mainPage.reg.inputName(name, surname, middlename);
    }

    @Test(groups = {"fillAccount"}, priority = 8)
    public void chooseDate() {
        mainPage.reg.pressDatepickerBtn();
        mainPage.reg.clickDate();
    }

    @Test(groups = {"fillAccount"}, priority = 9)
    public void typeCountry() {
        mainPage.reg.inputCountry();
    }

    @Test(groups = {"fillAccount"}, priority = 10)
    public void typeSecMail() {
        mainPage.reg.inputSecondEmail();
    }

    @Test(groups = {"fillAccount"}, priority = 11)
    public void typeCity() {
        mainPage.reg.inputCity();
    }

    @Test(groups = {"fillAccount"}, priority = 12)
    public void clickNavToCabinetBtn() {
        mainPage.reg.navToCab();
    }
}
