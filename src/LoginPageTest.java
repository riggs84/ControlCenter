import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

/**
 * Created by Victor on 27.04.2017.
 */
public class LoginPageTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://control.goodsync.com");
        System.out.println("initiation done");
    }
    @Test
    public void verifyUserCanLoginWithExistentAccount() throws Exception {
        UserLoginPage login = new UserLoginPage(driver);
        MainPage mainPage = login.loginAs("viktor.iurkov@yandex.ru", "123456");


    }
}
