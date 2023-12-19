package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By registrationButton = By.className("Auth_link__1fOlj");
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By recoverPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By loginHeaderText = By.xpath(".//h2[text()='Вход']");

    public LoginPage (WebDriver driver) {
        this.driver=driver;
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        new LoginPage(driver);
    }

    public LoginPage fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
        return new LoginPage(driver);
    }

    public boolean isLoginHeaderDisplayed() {
        return driver.findElement(loginHeaderText).isDisplayed();
    }
}

