import org.junit.Test;
import org.testng.Assert;

/**
 * Created by MartinRiggs on 4/12/2017.
 */
public class UserLoginPageTests {
    // TODO: configure running with creating class object in SetUp annotaion
    @Test
    public void loginRegisteredUser()
    {
        UserLoginPageSteps stepsPage = new UserLoginPageSteps();
        stepsPage.loginUser("some@email.com", "123456");
        Assert.assertEquals("someTitle",stepsPage.getTitle());
    }
    @Test
    public void loginNonRegisteredUser()
    {
        UserLoginPageSteps stepsPage = new UserLoginPageSteps();
        stepsPage.loginUser("nonRegistered@email.com", "123456");
        Assert.
    }



}
