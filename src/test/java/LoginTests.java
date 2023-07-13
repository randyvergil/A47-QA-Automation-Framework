
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest {

    //Fluent interfaces example
    @Test
    public void loginInvalidEmailValidPasswordTest(){

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@email.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
    }
    @Test
    public void loginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginValidEmailEmptyPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("demo@class.com")
                 .providePassword("")
                 .clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
    }

    //    OR
    @Test
    public void loginEmptyEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("").providePassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}