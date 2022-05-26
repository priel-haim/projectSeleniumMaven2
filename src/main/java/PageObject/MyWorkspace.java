package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import utilities.AllureAttachment;

public class MyWorkspace extends MenuPage {
	@FindBy(css = ".upgrade ")
	private WebElement UpgradeBtn;
	@FindBy(css = ".text-lg.text-white")
	private WebElement StartBtn;
	@FindBy(css = ".text-sm.flex.items-start>a")
	private List<WebElement> MenuList;
	@FindBy(css = "div:nth-child(2)>li>a")
	private WebElement Upgrade;
	@FindBy(css = ".rounded.bg-teal-500")
	private WebElement start;

	public MyWorkspace(WebDriver driver) {
		super(driver);
	}

	@Step("click on the button Start")
	public void StartProject() {
		sleep(500);
		AllureAttachment.attachElementScreenshot(StartBtn);
		click(StartBtn);
	}

	@Step("Upgrade my subscription")
	public void ClickUpgrade() {
		AllureAttachment.attachElementScreenshot(UpgradeBtn);
		sleep(500);
		click(UpgradeBtn);

	}

	@Step("Menu to select one of the templates")
	public void MenuAfterLogin(String name) {
		List<WebElement> list = MenuList;
		for (WebElement menuList : list) {
			if (getText(menuList).equalsIgnoreCase(name)) {
				click(menuList);
				break;
			}
		}
		sleep(1000);
	}

	@Step("Select Upgrade")
	public String GetUpgrade() {
		return getText(UpgradeBtn);
	}

	@Step("Click the Start button")
	public String GetStart() {
		return getText(start);
	}
}