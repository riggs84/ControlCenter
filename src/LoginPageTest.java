import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.java2d.cmm.Profile;

import java.util.concurrent.TimeUnit;

/**
 * Created by Victor on 27.04.2017.
 */
public class LoginPageTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\MartinRiggs\\Desktop\\SeleniumLibs\\Gecko\\geckodriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new FirefoxDriver(cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://control.goodsync.com");
    }


    @Test
    public void verifyUserCanLoginWithExistentAccount() throws Exception {
        UserLoginPage login = new UserLoginPage(driver);
        MainPage mainPage = login.loginAs("viktor.iurkov@yandex.ru", "123456");
        Assert.assertTrue("Company name is not equal", mainPage.isTextPresented("123456"));
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}
