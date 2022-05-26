package PageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObject.MenuPage;
import io.qameta.allure.Step;
import utilities.AllureAttachment;

public class CustomShirtConfiguratorPage extends MenuPage {
	// Create Your Shirt
	@FindBy(css = ".c-button.btn")
	private WebElement StartBtn;
	// Step 1:Choose a Fabric
	@FindBy(css = "[style='font-size: 14px;']")
	private List<WebElement> ColorBtn;
	// Step 2:Choose The Sleeve
	@FindBy(css = "[style='font-size: 14px;']")
	private List<WebElement> TheRightSleeveBtn;
	// Step 3:Choose The Cuff
	@FindBy(css = "[style='font-size: 14px;']")
	private List<WebElement> ClickYouCuffBtn;
	// Step 4:Choose the fitting
	@FindBy(css = "[style='font-size: 14px;']")
	private List<WebElement> ChooseYourFittingBtn;
	// Step 5:Choose the collar
	@FindBy(css = "[style='font-size: 14px;']")
	private List<WebElement> ChooseYourChooseBtn;
	// Step 6:Choose a size
	@FindBy(css = "span span")
	private WebElement SearchButtonBtn;
	@FindBy(css = ".el-select-dropdown__item>span")
	private List<WebElement> mySizeBtn;
	// Close the Project
	@FindBy(css = ".c-button-group-button.e-close")
	private WebElement closeProjectBtn;

	// for assert
	@FindBy(css = "div:nth-child(4)>span")
	private WebElement ChooseTheColor;
	@FindBy(css = "div:nth-child(2)>span")
	private WebElement ClickOnRightSleeve;
	@FindBy(css = "div:nth-child(2)>span")
	private WebElement ClickYouCuff;
	@FindBy(css = "div:nth-child(2)>span")
	private WebElement ChooseYourFitting;
	@FindBy(css = ".v-grid>div:nth-child(1)>span")
	private WebElement ChooseYourCollar;
	@FindBy(css = ".c-button.btn")
	private WebElement CreateYourCustomShirt;
	@FindBy(css = ".e-headline.is-shrinkable span")
	private WebElement yourShirt;

	// for element screenshot
	@FindBy(css = ".v-grid>div:nth-child(4)")
	private WebElement colorFabric;
	@FindBy(css = ".v-grid div:nth-child(2)")
	private WebElement shortSleeve;
	@FindBy(css = ".v-grid div:nth-child(2)")
	private WebElement cuffDoubleButton;
	@FindBy(css = ".v-grid div:nth-child(2)")
	private WebElement fittingSlim;
	@FindBy(css = ".v-grid>div:nth-child(1)")
	private WebElement collarPointy;
	@FindBy(css = "li:nth-child(2) span")
	private WebElement mySizeB;
	@FindBy(css = ".is-shrinkable>div>span")
	private WebElement MyShirtIsReady;

	public CustomShirtConfiguratorPage(WebDriver driver) {
		super(driver);
	}

	@Step("click on stat")
	public void CreateYourShirt() {
		AllureAttachment.attachElementScreenshot(StartBtn);
		click(StartBtn);
	}

	@Step("choose yuor color")
	public void ChooseFabric(String name) {
		sleep(200);
		List<WebElement> MyColor = ColorBtn;
		for (WebElement ChooseTheColorBtn : MyColor) {
			if (getText(ChooseTheColorBtn).contains(name)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(colorFabric);
				click(ChooseTheColorBtn);
				break;
			}
			sleep(2000);
		}
		sleep(2000);
	}

	@Step("Choose the right sleeve")
	public void ChooseTheSleeve(String name) {
		sleep(800);
		List<WebElement> sleeve = TheRightSleeveBtn;
		for (WebElement ClickOnRightSleeveBtn : sleeve) {
			if (getText(ClickOnRightSleeveBtn).contains(name)) {
				sleep(50);
				AllureAttachment.attachElementScreenshot(shortSleeve);
				click(ClickOnRightSleeveBtn);
				break;
			}
			sleep(2000);
		}
		sleep(2000);
	}

	@Step("Choose the appropriate cuff")
	public void ChooseTheCuff(String name) {
		sleep(2000);
		List<WebElement> cuff = ClickYouCuffBtn;
		for (WebElement ClickYouCuffBtn : cuff) {
			if (getText(ClickYouCuffBtn).contains(name)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(cuffDoubleButton);
				click(ClickYouCuffBtn);
				break;
			}
			sleep(2000);
		}
		sleep(2000);
	}

	@Step("Choosing a width for the back")
	public void ChooseTheFitting(String type) {
		sleep(2000);
		List<WebElement> BackOfTheShirt = ChooseYourFittingBtn;
		for (WebElement ChooseYourGeyserBtn : BackOfTheShirt) {
			if (getText(ChooseYourGeyserBtn).contains(type)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(fittingSlim);
				click(ChooseYourGeyserBtn);
				break;
			}
			sleep(2000);
		}
		sleep(2000);
	}

	@Step("choose your color")
	public void ChooseTheCollar(String type) {
		sleep(2000);
		List<WebElement> Collar = ChooseYourChooseBtn;
		for (WebElement ChooseYourChooseBtn : Collar) {
			if (getText(ChooseYourChooseBtn).contains(type)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(collarPointy);
				click(ChooseYourChooseBtn);
				break;
			}
			sleep(1000);
		}
	}

	@Step("choose your size")
	public void TheSizeOfTheShirt(String size) {
		click(SearchButtonBtn);
		sleep(2000);
		List<WebElement> mySize = mySizeBtn;
		for (WebElement mySizeBtn : mySize) {
			if (getText(mySizeBtn).contains(size)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(mySizeB);
				click(mySizeBtn);
				break;
			}
			sleep(2000);
		}
		sleep(2000);
	}

	@Step("Final result of the election")
	public void italianShirt(String[] type) {
		CreateYourShirt();
		ChooseFabric(type[0]);
		ChooseTheSleeve(type[1]);
		ChooseTheCuff(type[2]);
		ChooseTheFitting(type[3]);
		ChooseTheCollar(type[4]);
		TheSizeOfTheShirt(type[5]);

	}

	@Step("Choosing the right shirt")
	public String yourShirtIsReady() {
		return getText(yourShirt);

	}

}
