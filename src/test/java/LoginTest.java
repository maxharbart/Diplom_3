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
import pageObjects.RegistrationPage;
import pageObjects.PasswordRecoveryPage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginTest {

    private WebDriver driver;
    private final String email = "asdasd@esd.com";
    private final String password = "asdasd";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

    }

    @Test
    @DisplayName("Check login from lending")
    public void loginFromLending() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickLendingLoginButton();

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
    @DisplayName("Check login from button in personal account")
    public void loginFromPersonalAccountButton() {
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
    @DisplayName("Check login from registration page")
    public void loginWithLoginButtonFromRegistrationPage() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickLendingLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.clickLoginButton();

        LoginPage loginPage1 = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage1.fillEmailField(email);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage1.fillPasswordField(password);
        loginPage1.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.clickPersonalAccountButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        AccountPage personalAccountPage = new AccountPage(driver);

        Assert.assertTrue("Profile isn't shown, login was not successful", personalAccountPage.isProfileNameFieldDisplayed());
    }

    @Test
    @DisplayName("Check login from recover password page")
    public void loginWithRecoverPasswordButton() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickLendingLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRecoverPasswordButton();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);

        PasswordRecoveryPage recoverPasswordPage = new PasswordRecoveryPage(driver);
        recoverPasswordPage.clickLoginButtonOnRecoverPasswordPage();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);

        LoginPage loginPage1 = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage1.fillEmailField(email);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        loginPage1.fillPasswordField(password);
        loginPage1.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.clickPersonalAccountButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        AccountPage personalAccountPage = new AccountPage(driver);

        Assert.assertTrue("Profile isn't shown, login was not successful", personalAccountPage.isProfileNameFieldDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

