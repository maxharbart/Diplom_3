package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By constructor = By.xpath(".//h1[text()='Соберите бургер']");
    private final By sauce = By.xpath(".//span[text()='Соусы']");
    private final By bugs = By.xpath(".//span[text()='Булки']");
    private final By fillings = By.xpath(".//span[text()='Начинки']");
    private final By bunsActive = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    private final By sauceActive = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    private final By fillingsActive = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");

    private final By bugsHeader = By.xpath(".//h2[text()='Булки']");
    private final By sauceHeader = By.xpath(".//h2[text()='Соусы']");
    private final By fillingsHeader = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public MainPage clickLendingLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    public MainPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        return new MainPage(driver);
    }

    public boolean isConstructorVisible() {
        return driver.findElement(constructor).isDisplayed();
    }
    public MainPage clickSauceAnchor() {
        driver.findElement(sauce).click();
        return new MainPage(driver);
    }

    public MainPage clickBunsAnchor() {
        driver.findElement(bugs).click();
        return new MainPage(driver);
    }

    public MainPage clickFillingsAnchor() {
        driver.findElement(fillings).click();
        return new MainPage(driver);
    }

    public boolean isSauceHeaderVisible() {
        return driver.findElement(sauceActive).isDisplayed();
    }

    public boolean isBugsHeaderVisible() {
        return driver.findElement(bunsActive).isDisplayed();
    }

    public boolean isFillingsHeaderVisible() {
        return driver.findElement(fillingsActive).isDisplayed();
    }

    //методы для скролла до заголовков разделов
    public MainPage scrollToSauce() {
        Object sauceSection = driver.findElement(sauceHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sauceSection);
        return this;
    }

    public MainPage scrollToFillings() {
        Object fillingsSection = driver.findElement(fillingsHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fillingsSection);
        return this;
    }

    public MainPage scrollToBugs() {
        Object bugsSection = driver.findElement(bugsHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bugsSection);
        return this;
    }
}
