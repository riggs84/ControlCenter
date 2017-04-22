/**
 * Created by MartinRiggs on 4/12/2017.
 */
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
    private WebDriver driver;
    @FindBy(id = "userid")
    private WebElement email_field;

    @FindBy (name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement submitButton;

    public UserLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, UserLoginPage.class);
        // TODO check that right page is loaded

    }

    public UserLoginPage typeEmail(String email)
    {
        email_field.sendKeys(email);
        return this;
    }
    public UserLoginPage typePassword(String password)
    {
        passwordField.sendKeys(password);
        return this;
    }
    public MainPage submitBtn()
    {
        submitButton.click();
        return new MainPage();
    }
    public MainPage loginAs(String email, String password)
    {
        typeEmail(email);
        typePassword(password);
        return submitBtn();

    }









}
