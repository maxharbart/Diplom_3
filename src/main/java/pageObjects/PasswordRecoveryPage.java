package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;

    private static final By loginButton = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver=driver;
    }

    public PasswordRecoveryPage clickLoginButtonOnRecoverPasswordPage() {
        driver.findElement(loginButton).click();
        return new PasswordRecoveryPage(driver);
    }
}