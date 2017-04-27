import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by MartinRiggs on 4/22/2017.
 */
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, MainPage.class);
    }


}
