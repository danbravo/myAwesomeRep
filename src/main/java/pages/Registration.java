package pages;

import core.MethodsFact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration extends MethodsFact {
    private By patOption = By.xpath("//div[@class='form__td']/label[1]");
    private By specOption = By.xpath("//div[@class='form__td']/label[2]");
    private By yurOption = By.xpath("//div[@class='form__td']/label[3]");
    private By emailFld = By.xpath("//input[@id='email']");
    private By passwordFld = By.xpath("//input[@id='password']");
    private By password2Fld = By.xpath("//input[@id='password_2']");
    private By promoCode = By.xpath("//input[@id='promocode']");    //for spec
    private By offerBtn = By.xpath("//input[@id='check_offer']");
    private By finishRegBtn = By.xpath("//input[@id='reg_step1']");

    private By nameFld = By.xpath("//input[@id='form-validation-field-0']");
    private By surnameFld = By.xpath("//input[@id='form-validation-field-1']");
    private By middlenameFld = By.xpath("//input[@id='form-validation-field-2']");
    private By datepickerBtn = By.xpath("//div[@class='datepicker']/img");
    private By date = By.xpath("//td/a[contains(text(), 1)]");
    private By countyFld = By.xpath("//input[@id='form-validation-field-3']");
    private By confirmCountry = By.xpath("//body/ul/li");
    private By secondEmailFld = By.xpath("//input[@id='form-validation-field-4']");
    private By cityFld = By.xpath("//input[@id='form-validation-field-5']");
    private By confirmCity = By.xpath("//body/ul[2]/li[1]");
    private By navToCabinetBtn = By.xpath("//button[@class='btn btn_middle']");

    private String accOption;

    public void chooseRegOption(String option) {
        accOption = option;
        click(option.equalsIgnoreCase("pat") ? patOption :
                (option.equalsIgnoreCase("spec") ? specOption : yurOption));
        if (!accOption.equalsIgnoreCase("pat")) {
            typePromo();
        }
    }

    public void typeEmail(String emailText) {
        type(emailFld, emailText);
    }

    public void typePass(String passText) {
        type(passwordFld, passText);
        type(password2Fld, passText);
    }

    public void typePromo() {
        type(promoCode, "1234567899");
    }
    public void clickOffer() {
        click(offerBtn);
    }

    public void clickFinishRegBtn() {
        click(finishRegBtn);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElements(navToCabinetBtn).size() > 0;
            }
        });
//        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(navToCabinetBtn));
    }

    public void inputName(String name, String surname, String middlename) {
        type(nameFld, name);
        type(surnameFld, surname);
        type(middlenameFld, middlename);
    }

    public void pressDatepickerBtn() {
        click(datepickerBtn);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(date));
    }

    public void clickDate() {
        click(date);
    }

    public void inputCountry() {
        type(countyFld, "Украина");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(confirmCountry)).click();
    }

    public void inputSecondEmail() {
        type(secondEmailFld, "alalalal@mail.com");
    }

    public void inputCity() {
        type(cityFld, "Киев");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(confirmCity)).click();
    }

    public void navToCab() {
        click(navToCabinetBtn);
        waitForUrlContains("/cabinet", 10);
    }
}
