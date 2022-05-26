package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

import java.util.List;

public class ShoppingOrderFormPage extends MenuPage {
	// Open The Store
	@FindBy(css = ".c-button.btn")
	WebElement ShopNowBtn;

	// Pick your favorite look
	@FindBy(css = "[style='font-size: 14px;']")
	List<WebElement> StyleBtns;

	// What's your size?
	@FindBy(css = ".el-select__caret.el-input__icon")
	WebElement OpenYourSizeBtn;
	@FindBy(css = "div ul>.el-select-dropdown__item span")
	List<WebElement> YourSizeList;

	// What's your first name?
	@FindBy(css = "[placeholder='First Name*']")
	WebElement FnameField;

	// what's your last name & email?
	@FindBy(css = ".is-shrinkable>div>span")
	WebElement LastNameAndEmail;
	@FindBy(css = "[placeholder='Last Name']")
	WebElement LnameField;
	@FindBy(css = "[placeholder='Email*']")
	WebElement EmailField;
	@FindBy(css = ".c-button.btn")
	WebElement ContinueBtn;

	// which shipping method would you prefer?
	@FindBy(css = ".btn-secondary")
	List<WebElement> ShippingBtn;

	// where should we ship your attire?
	@FindBy(css = "[placeholder='Street address*']")
	WebElement StreetAddressField;
	@FindBy(css = ".zipCode-label>input")
	WebElement PostalCodeField;
	@FindBy(css = "[placeholder='City*']")
	WebElement CityField;
	@FindBy(css = "[placeholder='State*']")
	WebElement StateField;
	@FindBy(css = ".el-input__icon.el-icon-arrow-up")
	WebElement SelectCountryBtn;

	// Search My Country
	@FindBy(css = ".el-select-dropdown__wrap>ul>li span")
	List<WebElement> MyCountryList;

	// for Assert
	// click to start
	@FindBy(css = ".c-button.btn")
	WebElement ShopNow;
	// Choose Your Favorite Look
	@FindBy(css = "div:nth-child(4)>.c-image-answer-title")
	WebElement YuorShort;
	// Choose your size
	@FindBy(css = "li:nth-child(3)>span")
	WebElement YourSize;
	@FindBy(css = "label>span")
	WebElement FirstName;
	// What your name and last name adn your email?
	@FindBy(css = ".input-label.lastName-label>input")
	WebElement LastName;
	@FindBy(css = "/html/body/div[1]/div/div/div[3]/div/div/div[3]/div/div[3]/div/form/div/label/span")
	WebElement Email;
	// which shipping method would you prefer?
	@FindBy(css = "button:nth-child(4)")
	WebElement ShippingMethod;
	// Where to send the garment?
	@FindBy(css = ".e-headline span")
	WebElement ShippingAddress;
	@FindBy(css = "div:nth-child(1)>label>span")
	WebElement StreetAddress;
	@FindBy(css = "form>div:nth-child(2)>label>span")
	WebElement PostalCode;
	@FindBy(css = "div:nth-child(3)>label>span")
	WebElement City;
	@FindBy(css = "div:nth-child(4)>label>span")
	WebElement State;
	@FindBy(css = "div:nth-child(5)>div>label")
	WebElement Country;
	@FindBy(css = ".e-headline span")
	WebElement finalTile;
	//
	@FindBy(css = ".e-headline span")
	WebElement CheckingTheOrder;

	public ShoppingOrderFormPage(WebDriver driver) {
		super(driver);
	}

	@Step("Style Your Way")
	public void StyleYourWay() {
		sleep(1000);
		AllureAttachment.attachElementScreenshot(ShopNowBtn);
		click(ShopNowBtn);
		sleep(2000);
	}

	@Step("Pick Your Favorite Look")
	public void PickYourFavoriteLook(String styleName) {
		// List<WebElement> style = StyleBtn;
		for (WebElement StyleBtn : StyleBtns) {
			if (getText(StyleBtn).contains(styleName)) {
				AllureAttachment.attachElementScreenshot(StyleBtn);
				click(StyleBtn);
				break;
			}
		}
		sleep(2000);
	}

	@Step("Your Size")
	public void YourSize(String value) {
		click(OpenYourSizeBtn);
		List<WebElement> size = YourSizeList;
		for (WebElement YourSizeList : size) {
			sleep(1000);
			if (getText(YourSizeList).contains(value)) {
				sleep(1000);
				AllureAttachment.attachElementScreenshot(YourSizeList);
				click(YourSizeList);
				break;
			}
		}
		sleep(1000);
	}

	@Step("What's your First Name")
	public void FirstName(String fname) {
		fillText(FnameField, fname);
		sleep(500);
		click(ContinueBtn);
		AllureAttachment.attachElementScreenshot(FnameField);
	}

	@Step("What's your Last Name And your Email")
	public void LastNameAndEmail(String lname, String email) {
		fillText(LnameField, lname);
		sleep(2000);
		AllureAttachment.attachElementScreenshot(LnameField);
		fillText(EmailField, email);
		sleep(1000);
		AllureAttachment.attachElementScreenshot(EmailField);
		click(ContinueBtn);
	}

	@Step("which shipping method would you prefer?")
	public void PreferShipping(String text) {
		List<WebElement> shipping = ShippingBtn;
		for (WebElement ShippingBtn : shipping) {
			if (getText(ShippingBtn).contains(text)) {
				AllureAttachment.attachElementScreenshot(ShippingBtn);
				click(ShippingBtn);
				break;
			}
			sleep(2000);
		}
		sleep(2000);
	}

	@Step("where should we ship your attire?")
	public void ShippingAddress(String[] address) {
		fillText(StreetAddressField, address[0]);
		sleep(2000);
		AllureAttachment.attachElementScreenshot(StreetAddressField);
		fillText(PostalCodeField, address[1]);
		sleep(1000);
		AllureAttachment.attachElementScreenshot(PostalCodeField);
		fillText(CityField, address[2]);
		sleep(1000);
		AllureAttachment.attachElementScreenshot(CityField);
		fillText(StateField, address[3]);
		sleep(1000);
		AllureAttachment.attachElementScreenshot(StateField);
		click(SelectCountryBtn);
		sleep(500);
//		AllureAttachment.attachElementScreenshot(SelectCountryBtn);
		List<WebElement> country = MyCountryList;
		for (WebElement MyCountryList : country) {
			if (getText(MyCountryList).contains(address[4])) {
				AllureAttachment.attachElementScreenshot(MyCountryList);
				click(MyCountryList);
				break;
			}
			sleep(5);
		}
		sleep(1000);
		click(ContinueBtn);
	}

	@Step("Concentration of customer data")
	public void fillOrderForm(String styleName, String size, String fName, String lName, String email, String[] address,
			String shippingMethod) {
		StyleYourWay();
		PickYourFavoriteLook(styleName);
		YourSize(size);
		FirstName(fName);
		LastNameAndEmail(lName, email);
		PreferShipping(shippingMethod);
		ShippingAddress(address);
		sleep(1000);

	}

	@Step("Opening a store")
	public String openTheShop() {
		return getText(ShopNow);
	}

	@Step("End of purchase")
	public String getTitle() {
		return getText(finalTile);
	}

}
