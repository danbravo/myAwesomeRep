package pages;

import core.MethodsFact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class LogIn extends MethodsFact{
    private By emailFld = By.id("email");
    private By passFld = By.id("password");
    private By proceedLogInBtn = By.xpath("//input[@name='login']");

    private By profilePageBtn = By.xpath("//h3/a");
    private By nameFld = By.xpath("//div[@class='inform__left']//div[@class='form']/div[1]/input");
    private By surnameFld = By.xpath("//div[@class='inform__left']//div[@class='form']/div[2]/input");
    private By midnameFld = By.xpath("//div[@class='inform__left']//div[@class='form']/div[3]/input");
    private By maleRadioBtn = By.xpath("//input[@value='male']");
    private By femaleRadioBtn = By.xpath("//input[@value='female']");
    private By calendarBtn = By.xpath("//*[@id='borndate']");

    private By saveInfoBtn = By.xpath("//div[@class='inform__foot']/button");
    private By popupSaveBtn = By.xpath("//*[@id='error_popup']//button");

    @Step("Typing user email")
    public void typeEmail(String email) {
        type(emailFld, email);
    }

    @Step("Typing user password")
    public void typePass(String pass) {
        type(passFld, pass);
    }

    @Step("Logging in")
    public void clickProceedLogInBtn() {
        click(proceedLogInBtn);
        waitForUrlContains("cabinet", 10);
    }

    @Step("Opening profile page")
    public void clickProfilePageBtn() {
        click(profilePageBtn);
        waitForUrlContains("edit_profile", 10);
    }

    @Step("Changing user name, surname and midname to : {0}, {1}, {2}")
    public void typeNames(String name, String surname, String midname) {
        type(nameFld, name);
        type(surnameFld, surname);
        type(midnameFld, midname);
        MainPage.txtAttachment("new user info", name, surname, midname);
    }

    @Step("Changing user gender to : {0}")
    public void chooseGender(String gender) {
        click(gender.equalsIgnoreCase("male") ? maleRadioBtn : femaleRadioBtn);
    }

    @Step("Opening calendar")
    public void clickCalendar() {
        click(calendarBtn);
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.findElements(By.xpath("//*[@id='ui-datepicker-div']/table")).size() > 0;
//            }
//        });
        ExpectedCondition<Boolean> exp = driver -> driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table")).size() > 0;
        new WebDriverWait(driver, 10).until(exp);
    }

    @Step("Changing birth date to : {0}")
    public void chooseDate(String date) {
        click(By.xpath("//td/a[contains(text(), "+date+")]"));
    }

    @Step("Saving profile changes")
    public void clickSaveBtn() {
        click(saveInfoBtn);
    }

    @Step("Clicking 'proceed' button after saving")
    public void clickProceedSaveBtn() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(popupSaveBtn)).click();
        Assert.assertTrue((new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElements(profilePageBtn).size() > 0;
            }
        }));
//        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(profilePageBtn));
    }
}
