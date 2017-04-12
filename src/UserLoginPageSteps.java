/**
 * Created by MartinRiggs on 4/12/2017.
 */
public class UserLoginPageSteps {
    private UserLoginPage page = null;

    public UserLoginPageSteps()
    {
        page = new UserLoginPage();
    }

    public void loginUser(String email, String password)
    {
        page.setEmail_field(email);
        page.setPassword_field(password);
        page.submit_button.click();
    }
    public String getTitle()
    {
        return page.getPageTitle();
    }



}
