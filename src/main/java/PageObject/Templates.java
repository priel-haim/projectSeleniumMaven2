package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import PageObject.MenuPage;
import io.qameta.allure.Step;
import utilities.AllureAttachment;

public class Templates extends MenuPage {
	@FindBy(css = ".dataTables_wrapper")
	private List<WebElement> PageTemplatesBtn;
	@FindBy(css = ".c-list-header>.e-title")
	private WebElement IQTestBtn;
	@FindBy(css = "[alt='Technology Quiz']")
	private WebElement TechnologyQuizBtn;
	@FindBy(css = "#template-gallery>tbody>tr>td:nth-child(1)>div")
	private List<WebElement> TempletesQuiz;
	@FindBy(css = ".e-button-container>.btn-preview")
	private WebElement ClickTemplateBtn;
	@FindBy(css = ".c-thumbnail.gallery-item")
	private List<WebElement> AllTemplatesList;
	@FindBy(css = ".c-button-group-button.e-close")
	private WebElement CloseTemplateBtn;
	// Upgrade
	@FindBy(css = ".nav-link.upgrade")
	private WebElement UpgradeBtn;
	// for assert

	@FindBy(css = "[title='Shopping Order Form']")
	private WebElement ShoppingOrderForm;
	@FindBy(css = "[title='Technology Quiz']")
	private WebElement TechnologyQuiz;
	@FindBy(css = "[title='Custom Shirt Configurator']")
	private WebElement CustomShirt;

	public Templates(WebDriver driver) {
		super(driver);
	}

	@Step("Select the template") //
	public void ChooseTemplate(String name) {
		List<WebElement> list = AllTemplatesList;
		for (WebElement AllTemplatesList : list) {
			if (getText(AllTemplatesList).contains(name)) {
				AllureAttachment.attachElementScreenshot(AllTemplatesList);
				click(AllTemplatesList);
				sleep(2000);
				break;
			}
			sleep(1000);
		}
	}

	@Step("Technology Quiz")
	public void TechnologyQuiz() {
		click(TechnologyQuizBtn);
	}

	@Step("Close Template")
	public void CloseTemplate() {
		click(CloseTemplateBtn);
	}

	@Step("My Upgrad")
	public void Upgrade() {
		click(UpgradeBtn);
	}

	@Step("Get the shopping order form")
	public String GetShoppingOrderForm() {
		return getText(ShoppingOrderForm);
	}

	@Step("View a technology Custom Shirt Configurator")
	public String GetCustomShirt() {
		return getText(CustomShirt);
	}

	@Step("View a technology quiz")
	public String GetTechnologyQuiz() {
		return getText(TechnologyQuiz);
	}

}
