import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.MainPage;
import pageObjects.LoginPage;
import pageObjects.AccountPage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class YandexAccountTest {
    private WebDriver driver;
    private final String email = "maxharbart1@yandex.ru";
    private final String password = "password1";

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/yandexdriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Check login and creating of personal account")
    public void loginFromLending() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillEmailField(email);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.clickPersonalAccountButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        AccountPage personalAccountPage = new AccountPage(driver);

        Assert.assertTrue("Profile isn't shown, login was not successful", personalAccountPage.isProfileNameFieldDisplayed());
    }

    @Test
    @DisplayName("Check transition from personal account to constructor")
    public void checkTransitionFromPersonalAccountToConstructor(){
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillEmailField(email);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.clickPersonalAccountButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        AccountPage personalAccountPage = new AccountPage(driver);
        personalAccountPage.clickConstructorButton();

        MainPage mainPage2 = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        Assert.assertTrue("Constructor isn't displayed", mainPage2.isConstructorVisible());
    }

    @Test
    @DisplayName("Check transition from personal account to constructor with using of logo")
    public void checkTransitionFromPersonalAccountToConstructorWithLogo(){
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillEmailField(email);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.clickPersonalAccountButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        AccountPage personalAccountPage = new AccountPage(driver);
        personalAccountPage.clickLogoField();

        MainPage mainPage2 = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        Assert.assertTrue("Constructor isn't displayed", mainPage2.isConstructorVisible());
    }

    @Test
    @DisplayName("Check logout from personal account")
    public void isAccountLogoutPossible() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillEmailField(email);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.clickPersonalAccountButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        AccountPage personalAccountPage = new AccountPage(driver);
        personalAccountPage.clickLogoutButton();

        LoginPage loginPage1 = new LoginPage(driver);

        Assert.assertTrue(loginPage1.isLoginHeaderDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
