package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;

    private final By profileNameField = By.xpath(".//input[@name='name']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By logOutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    public AccountPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isProfileNameFieldDisplayed() {
        return driver.findElement(profileNameField).isDisplayed();
    }

    public pageObjects.AccountPage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new pageObjects.AccountPage(driver);
    }

    public pageObjects.AccountPage clickLogoField() {
        driver.findElement(logo).click();
        return new pageObjects.AccountPage(driver);
    }

    public pageObjects.AccountPage clickLogoutButton() {
        driver.findElement(logOutButton).click();
        return new pageObjects.AccountPage(driver);
    }
}

