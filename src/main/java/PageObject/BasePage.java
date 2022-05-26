package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);

	}

	protected void fillText(WebElement webelement, String text) {
		highlightElement(webelement, "blue");
		webelement.clear();
		webelement.sendKeys(text);
	}

	protected void click(WebElement webelement) {
		// highlight
		highlightElement(webelement, "green");
		webelement.click();
	}

	protected String getText(WebElement webelement) {
		highlightElement(webelement, "green");
		return webelement.getText();
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException t) {
			t.printStackTrace();
		}

	}

	protected void selectByValue(WebElement webelement, String value) {
		Select select = new Select(webelement);
		select.selectByValue(value);
	}

	public void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
	}
}
