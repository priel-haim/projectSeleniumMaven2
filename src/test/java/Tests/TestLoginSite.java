package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.LoginPage;
import PageObject.MyMenu;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;

public class TestLoginSite extends BaseTest {

	@Story("")
	@Issue("1")
	@Test(description = "Sign in with my name details")
	public void tc01_LoginSite() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		Assert.assertEquals(loginPage.MyLogin(), "Haim-a");
	}

	@Story("")
	@Issue("2")
	@Test(description = "To return to the main screen, you need to press loguot")
	public void tc02_SignOut() {
		MyMenu yourMenu = new MyMenu(driver);
		yourMenu.UserMenu("Log Out");
		String option = "logout";
		driver.get("https://app.involve.me/login");
		Assert.assertTrue(driver.getTitle() != option);
	}

	@Story("")
	@Issue("")
	@Test(description = "You have the option to reset the password via email and I forgot my password")
	public void tc03_ForgetMyPassworf() {
		MyMenu yourMenu = new MyMenu(driver);
		yourMenu.ForgetPassword("prili2@walla.com");
		String condition1 = "Forgot password";
		driver.get("https://app.involve.me/password/reset");
		Assert.assertTrue(condition1 != driver.getTitle());
	}
}
