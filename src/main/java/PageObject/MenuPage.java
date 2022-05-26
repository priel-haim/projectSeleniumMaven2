package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class MenuPage extends BasePage {

	// Close the Project
	@FindBy(css = ".float-right>img")
	private WebElement closeProjectBtn;
	// for assert
	// Button for closing the project
	@FindBy(css = ".e-close img")
	private WebElement close;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	@Step("exit from the project")
	public String exitTheProject() {
		return getText(closeProjectBtn);

	}

}
