package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;

    private final By nameField = By.xpath(".//input[@name='name']");
    private final By emailField = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input"); //(".//label[text()='Email']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By notCorrectPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private final By loginButtonOnRegistrationPage = By.xpath(".//a[text()='Войти']");

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage fillNameField(String username) {
        driver.findElement(nameField).sendKeys(username);
        return this;
    }

    public RegistrationPage fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationPage fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public RegistrationPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    public boolean isIncorrectPasswordMessageDisplayed() {
        return driver.findElement(notCorrectPasswordMessage).isDisplayed();
    }

    public RegistrationPage clickLoginButton() {
        driver.findElement(loginButtonOnRegistrationPage).click();
        return new RegistrationPage(driver);
    }
}