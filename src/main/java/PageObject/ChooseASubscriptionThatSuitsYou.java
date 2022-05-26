package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.AllureAttachment;
import java.util.List;

public class ChooseASubscriptionThatSuitsYou extends MenuPage {

	@FindBy(css = "#pills-monthly-tab")
	private WebElement MonthlyOrYearlyBtn;
	@FindBy(css = "#pills-monthly a>button")
	private List<WebElement> TheUpgradePriceBtn;
	@FindBy(css = ".e-title")
	private WebElement suitableSubscription;

	// for assert
	@FindBy(css = "#pills-monthly div:nth-child(3) a>button")
	private WebElement typeMonthly;

	public ChooseASubscriptionThatSuitsYou(WebDriver driver) {
		super(driver);
	}

	@Step("Choose a subscription type in months or years")
	public void chooseMonthlyOrYearly(String TypeContract) {
		AllureAttachment.attachElementScreenshot(MonthlyOrYearlyBtn);
		click(MonthlyOrYearlyBtn);
	}

	@Step("What type of subscription do you want?")
	public void typeUpgrade(String upgrade) {
		List<WebElement> list = TheUpgradePriceBtn;
		for (WebElement TheUpgradePriceBtn : list) {
			if (getText(TheUpgradePriceBtn).contains(upgrade)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(TheUpgradePriceBtn);
				click(TheUpgradePriceBtn);
				break;
			}
			sleep(1000);
		}
		sleep(2000);
	}

	@Step("Choose Suitable Subscription")
	public String GetChooseSuitableSubscription() {
		return getText(suitableSubscription);
	}

	@Step("Choose Type Upgrade")
	public String GetChooseTypeUpgrade() {
		wait.until(ExpectedConditions.visibilityOf(typeMonthly));
		return getText(typeMonthly);
	}
}
