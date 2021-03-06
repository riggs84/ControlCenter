import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Victor on 27.04.2017.
 */
public class LoginPageTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://control.goodsync.com");
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void verifyUserCanLoginWithExistentAccount() throws Exception {
        UserLoginPage login = new UserLoginPage(driver);
        MainPage mainPage = login.loginAs("viktor.iurkov@yandex.ru", "123456");
        Assert.assertTrue(mainPage.isTextPresented("123456"));
    };
}
