package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;
import java.util.List;

public class MyMenu extends MenuPage {

	@FindBy(css = ".fas.fa-caret-down.ml-2")
	private WebElement yourAccountField;
	@FindBy(css = "div>.darken")
	private WebElement forgetBtn;
	@FindBy(css = "[autocomplete='username']")
	private WebElement forgetPasswordField;
	@FindBy(css = ".btn.btn-primary")
	private WebElement messageEmailBtn;
	@FindBy(css = ".nav-item.dropdown")
	private WebElement OpenMenulist;
	@FindBy(css = ".dropdown-menu.w-auto.whitespace-no-wrap.absolute.bg-white.shadow-md>li>a")
	private List<WebElement> Menulist;
	@FindBy(css = "li:nth-child(13) a")
	private WebElement logOut;
	@FindBy(css = ".form-login div:nth-child(6)>div>a")
	private WebElement pageForgetPassword;

	public MyMenu(WebDriver driver) {
		super(driver);
	}

	@Step("Button and selection in the My Username menu")
	public void UserMenu(String name) {
		click(yourAccountField);
		sleep(2000);
		List<WebElement> list = Menulist;
		for (WebElement menuList : list) {
			if (getText(menuList).equalsIgnoreCase(name)) {
				AllureAttachment.attachElementScreenshot(menuList);
				click(menuList);
				break;
			}
		}
		sleep(1000);
	}

	@Step("If you forget the password, click on I forgot the password and enter the email to reset")
	public void ForgetPassword(String Email) {
		AllureAttachment.attachElementScreenshot(pageForgetPassword);
		click(forgetBtn);
		sleep(1000);
		fillText(forgetPasswordField, Email); // forget your password
		AllureAttachment.attachElementScreenshot(forgetPasswordField);
		sleep(2000);
		click(messageEmailBtn); // message to Email
	}
}