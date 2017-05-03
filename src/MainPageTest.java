import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by Victor on 03.05.2017.
 */
public class MainPageTest {
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
}
