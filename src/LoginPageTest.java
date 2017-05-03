import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.java2d.cmm.Profile;

import java.util.concurrent.TimeUnit;

/**
 * Created by Victor on 27.04.2017.
 */
public class LoginPageTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\Victor\\Desktop\\SeleniumLibs\\Gecko\\geckodriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new FirefoxDriver(cap);
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-logout")));
        Assert.assertTrue("Company name is not presented", mainPage.isTextPresented("123456"));
    }
    @Test
    public void shouldNotLoginWithBadPassword() throws Exception
    {
        UserLoginPage login = new UserLoginPage(driver);
        login.typeEmail("viktor.iurkov@yandex.ru");
        login.typePassword("1234567");
        login.submitBtnWithBadCredentials();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/form/div/div")));
        Assert.assertTrue(driver.getPageSource().contains("Incorrect UserId or Password"));
    }
    @Test
    public void shouldNotLoginWithBadEmail() throws Exception
    {
        UserLoginPage login = new UserLoginPage(driver);
        login.typeEmail("some@email.ru");
        login.typePassword("123456");
        login.submitBtnWithBadCredentials();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/form/div/div")));
        Assert.assertTrue(driver.getPageSource().contains("Incorrect UserId or Password"));
    }
}
