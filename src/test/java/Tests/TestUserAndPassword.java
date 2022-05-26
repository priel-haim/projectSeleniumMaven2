package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.LoginPage;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;

public class TestUserAndPassword extends BaseTest {

    @Link("https://www.involve.me/")
    @Story("Check by entering an incorrect username and password, if possible to log in")
    @Issue("")
    @Test(description = "use incorrect login information")
	public void tc01_OpenLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLogin();
        loginPage.LoginToErrorMassage("prielha1234@gmail.com", "password");
        String actual = loginPage.GetErrorMessage();
		String expected = "These credentials do not match our records.";
		Assert.assertEquals(actual, expected);
    }

	@Story("")
	@Issue("")
	@Test(dataProvider = "getData", description = "use incorrect login information")
	public void tc02_OpenLogin2(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToErrorMassage(username, password);
		String actual = loginPage.GetErrorMessage();
		String expected = "These credentials do not match our records.";
		Assert.assertEquals(actual, expected);
	}

    @DataProvider
    public Object[][] getData() {
        Object[][] myData = {
                {"pppp@gmail.com", "111111"},
                {"papa@walla.co.il", "123456"},
                {"prielha1234@gmail.com", "1985"},
                {"prielhaim7485@gmail.com", "PrielHam1985"},
        };
        return myData;
    }
}