/**
 * Created by MartinRiggs on 4/12/2017.
 */
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
    private WebDriver driver;

    @FindBy(id = "userid")
    //@FindBy(xpath = ".//*[@id='userid']")
    private WebElement emailField;

    @FindBy (name = "password")
    //@FindBy(xpath = ".//*[@id='frm-login']/fieldset/div/div[2]/input")
    private WebElement passwordField;

    @FindBy(name = "login")
    //@FindBy(xpath = ".//*[@id='frm-login']/fieldset/div/div[3]/input")
    private WebElement submitButton;

    public UserLoginPage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        /*check that right page is loaded */
        if (!verifyPageTitle()) {
            throw new Exception("Wrong page is loaded on initiation");
        }
    }

    public UserLoginPage typeEmail(String email)
    {
        emailField.sendKeys(email);
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
        return new MainPage(driver);
    }
    public MainPage loginAs(String email, String password)
    {
        typeEmail(email);
        typePassword(password);
        return submitBtn();
    }
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    public boolean verifyPageTitle()
    {
        return getPageTitle().contains("JobServer Enterprise");
    }











}
