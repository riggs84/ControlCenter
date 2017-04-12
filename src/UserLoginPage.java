/**
 * Created by MartinRiggs on 4/12/2017.
 */
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
    WebDriver driver;
    @FindBy(id = "userid")
    WebElement email_field;

    @FindBy (name = "password")
    WebElement password_field;

    @FindBy(name = "login")
    WebElement submit_button;

    public UserLoginPage()
    {
        driver = new HtmlUnitDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://control.goodsync.com");
    }

    public void setEmail_field(String email)
    {
        email_field.sendKeys(email);
    }
    public void setPassword_field(String password)
    {
        password_field.sendKeys(password);
    }
    public String getPageTitle()
    {
        return driver.getTitle();
    }





}
