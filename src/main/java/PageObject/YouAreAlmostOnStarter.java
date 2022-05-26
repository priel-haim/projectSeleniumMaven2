package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import utilities.AllureAttachment;

public class YouAreAlmostOnStarter extends MenuPage {

    // Your Payment Details
    @FindBy(css = "#card-holder-name")
    private WebElement NameField;
    // Frame
    @FindBy(css = "div iframe")
    private WebElement Frame;
    @FindBy(css = "[name='cardnumber']")
    private WebElement NumCardField;
    @FindBy(css = "[name='exp-date']")
    private WebElement DateCardField;
    @FindBy(css = "[name='cvc']")
    private WebElement SecurityNumbersField;
    @FindBy(css = "label>#coupon")
    private WebElement CouponField;

    // Your Billing Details
    @FindBy(css = "#first_name")
    private WebElement firstNameField;
    @FindBy(css = "#last_name")
    private WebElement lastNameField;
    @FindBy(css = "#company")
    private WebElement companyField;
    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#phone")
    private WebElement phoneField;
    @FindBy(css = "#street")
    private WebElement streetField;
    @FindBy(css = "#street_no")
    private WebElement streetNoField;
    @FindBy(css = "#zip")
    private WebElement ZIPCodeField;
    @FindBy(css = "#city")
    private WebElement cityField;
    @FindBy(css = "label #country")
    private WebElement countryList;

    // I agree to the involve.me
    @FindBy(css = "span>label")
    private WebElement IagreeBtn;
    @FindBy(css = "div #payment-submit")
    private WebElement PaymentBtn;
    @FindBy(css = ".col-sm-12>div>div:nth-child(2)")
    private WebElement FinalApproval;


    // where is the your payment details?
    @FindBy(css = "#payment-form .col-sm-6.align-self-top")
    private WebElement YourPaymentDetails;

    // where is the your billing details?
    @FindBy(css = "#payment-form .col-sm-12.align-self-top>div>div:nth-child(1)")
    private WebElement YourBillingDetails;

    // Your order summary
    @FindBy(css = ".order-summary>h5")
    private WebElement YourOrderSummary;

    // finish the upgrade
    @FindBy(css = ".order-summary h5")
    private WebElement orderSummary;

    public YouAreAlmostOnStarter(WebDriver driver) {
        super(driver);
    }

    @Step("your payment details")
    public void yourPaymentDetails1(String Name, String NumCard, String DateCard, String SecurityNumbers, String Coupon) {
        fillText(NameField, Name);
        // move to frame
        driver.switchTo().frame(Frame);
        fillText(NumCardField, NumCard);
        fillText(DateCardField, DateCard);
        fillText(SecurityNumbersField, SecurityNumbers);
        //  move back from frame
        driver.switchTo().defaultContent();
        fillText(CouponField, Coupon);
    }

    @Step("your billing details")
    public void yourBillingDetails1(String firstName, String lastName, String company, String email, String phone, String street, String streetNo, String ZIPCode, String city, String country) {
        fillText(firstNameField, firstName);
        fillText(lastNameField, lastName);
        fillText(companyField, company);
        fillText(emailField, email);
        fillText(phoneField, phone);
        fillText(streetField, street);
        fillText(streetNoField, streetNo);
        fillText(ZIPCodeField, ZIPCode);
        fillText(cityField, city);
        selectByValue(countryList, country);
    }

//    @Step("Filling in credit card information")
//    public void yourPaymentDetails(String[] paymentDetails) {
//        fillText(NameField, paymentDetails[0]);
//        // move to frame
//        driver.switchTo().frame(Frame);
//        fillText(NumCardField, paymentDetails[1]);
//        fillText(DateCardField, paymentDetails[2]);
//        fillText(SecurityNumbersField, paymentDetails[3]);
//        // move Back the window
//        driver.switchTo().defaultContent();
//        AllureAttachment.attachElementScreenshot(YourPaymentDetails);
//        fillText(CouponField, paymentDetails[4]);
//    }

//    @Step("Filling in personal details")
//    public void yourBillingDetails(String[] BillingDetails) {
//        fillText(firstNameField, BillingDetails[0]);
//        fillText(lastNameField, BillingDetails[1]);
//        fillText(companyField, BillingDetails[2]);
//        fillText(emailField, BillingDetails[3]);
//        fillText(phoneField, BillingDetails[4]);
//        fillText(streetField, BillingDetails[5]);
//        fillText(streetNoField, BillingDetails[6]);
//        fillText(ZIPCodeField, BillingDetails[7]);
//        fillText(cityField, BillingDetails[8]);
//        AllureAttachment.attachElementScreenshot(YourBillingDetails);
//        selectByValue(countryList, BillingDetails[9]);
//    }

    @Step("Final approval")
    public void yourOrderSummary() {
        AllureAttachment.attachElementScreenshot(FinalApproval);
        click(IagreeBtn);
        click(PaymentBtn);
    }

//	public void almostOnBusiness(String[] paymentDetails, String[] BillingDetails, String yourOrderSummary) {
//		yourPaymentDetails(paymentDetails);
//		yourBillingDetails(BillingDetails);
//		yourOrderSummary();
//	}

    public String yourOrderSummaryy() {
        return getText(orderSummary);
    }
}
