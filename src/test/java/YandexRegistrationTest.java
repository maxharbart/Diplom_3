import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.AccountPage;
import pageObjects.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;

import static java.util.concurrent.TimeUnit.SECONDS;

public class YandexRegistrationTest {

    private WebDriver driver;
    private WebDriver yandexDriver;
    private String userName = "Max";
    private String email = RandomStringUtils.randomAlphabetic(6, 10).toLowerCase() + "@example.com";
    private String password = "password1";

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/yandexdriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver = new ChromeDriver(options);
    }


    @Test
    @DisplayName("Check possibility of registration")
    public void CheckThatRegistrationIsPossible() {
        driver.manage().timeouts().implicitlyWait(7, SECONDS);

        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickLendingLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.fillNameField(userName);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.fillEmailField(email);
        registrationPage.fillPasswordField(password);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.clickRegistrationButton();

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

        Assert.assertTrue("Profile isn't shown, registration was not successful", accountPage.isProfileNameFieldDisplayed());
    }

    @Test
    @DisplayName("Check message of incorrect password in registration")
    public void checkIncorrectPasswordMessage() {
        driver.manage().timeouts().implicitlyWait(7, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickLendingLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.fillNameField("User");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.fillEmailField("user@yandex.ru");
        registrationPage.fillPasswordField("55555");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        registrationPage.clickRegistrationButton();

        Assert.assertTrue(registrationPage.isIncorrectPasswordMessageDisplayed());
    }

    @After
    public void tearDown() {
      if (driver != null) {
          driver.quit();
      }
    }

}

