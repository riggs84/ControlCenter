import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by MartinRiggs on 4/22/2017.
 */
public class MainPage {
    private WebDriver driver;

    @FindBy (id = "btn-logout")
    private WebElement logoutBtn;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isTextPresented(String str)
    {
        if (driver.getPageSource().contains(str))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    


}
