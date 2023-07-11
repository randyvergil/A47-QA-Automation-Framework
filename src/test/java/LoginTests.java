
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest {

    //Fluent interfaces example
    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(String username, String password){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(username)
                 .providePassword(password)
                 .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
    @Test
    public void loginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginValidEmailEmptyPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    //    OR
    @Test
    public void loginEmptyEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("").providePassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}