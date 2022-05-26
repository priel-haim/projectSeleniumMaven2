package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import PageObject.MenuPage;
import io.qameta.allure.Step;
import utilities.AllureAttachment;

public class ChooseProjectType extends MenuPage {

	// choose project
	@FindBy(css = "#app-layout>.container>div:nth-child(3)>div>a>div>.title")
	private List<WebElement> TemplateTitleType;

	// for assert
	@FindBy(css = "div:nth-child(3) a:nth-child(1) .title")
	private WebElement Quiz;
	@FindBy(css = "a:nth-child(5) .title")
	private WebElement PaymentForm;

	public ChooseProjectType(WebDriver driver) {
		super(driver);
	}

	@Step("Need to select the template type") //
	public void ChooseProject(String name) {
		List<WebElement> list = TemplateTitleType;
		for (WebElement TemplateTitleType : list) {
			if (getText(TemplateTitleType).equalsIgnoreCase(name)) {
				sleep(500);
				AllureAttachment.attachElementScreenshot(TemplateTitleType);
				click(TemplateTitleType);
				break;
			}
			sleep(1000);
		}
		sleep(2000);
	}

	@Step("Choose the quiz format")
	public String QuizTypeProject() {
		return getText(Quiz);
	}

	@Step("Choose the payment format")
	public String PaymentFormTypeProject() {
		return getText(PaymentForm);
	}

}
