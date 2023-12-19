import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.MainPage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class YandexConstructorTest {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/yandexdriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Check transition to sauces in constructor")
    public void clickHeaderToSauceTransition() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickSauceAnchor();

        Assert.assertTrue(mainPage.isSauceHeaderVisible());
    }

    @Test
    @DisplayName("Check transition to bugs in constructor")
    public void clickHeaderToBugsTransition() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickSauceAnchor();
        mainPage.clickBugsAnchor();

        Assert.assertTrue(mainPage.isBugsHeaderVisible());
    }

    @Test
    @DisplayName("Check transition to fillings in constructor")
    public void clickHeaderToFillingsTransition() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.clickFillingsAnchor();

        Assert.assertTrue(mainPage.isFillingsHeaderVisible());
    }

    @Test
    @DisplayName("Check transition to sauces in constructor with using scroll")
    public void scrollToSauceTransition() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.scrollToSauce();

        Assert.assertTrue(mainPage.isSauceHeaderVisible());
    }

    @Test
    @DisplayName("Check transition to bugs in constructor with using scroll")
    public void scrollToBugsTransition() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.scrollToSauce();
        mainPage.scrollToBugs();

        Assert.assertTrue(mainPage.isBugsHeaderVisible());
    }

    @Test
    @DisplayName("Check transition to fillings in constructor with using scroll")
    public void scrollToFillingsTransition() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        mainPage.scrollToFillings();

        Assert.assertTrue(mainPage.isFillingsHeaderVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
