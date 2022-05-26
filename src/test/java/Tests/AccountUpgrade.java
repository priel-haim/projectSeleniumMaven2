package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.ChooseASubscriptionThatSuitsYou;
import PageObject.LoginPage;
import PageObject.MyWorkspace;
import PageObject.YouAreAlmostOnStarter;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import utilities.AllureAttachment;

public class AccountUpgrade extends BaseTest {
//    private String[] paymentDetails = {"Haim Navon", "4580-0303-3333-8353", "1226", "333", "ert54v6"};
//	private String[] BillingDetails = { "Haim", "Navon", "PHA", "p-azoulay@gmail.com", "052-2345672", "Rakefet", "15",
//			"99000", "bait shemesh", "IL" };
    private String payment = "Your order summary";

    @Story("To log in, you need to enter the correct username and password")
    @Issue("")
    @Test(description = "Sign in with my name details")
    public void tc01_OpenLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLogin();
        loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
        Assert.assertEquals(loginPage.MyLogin(), "Haim-a");
    }

    @Story("")
    @Issue("")
    @Test(description = "click on the button to upgrade")
    public void tc02_ChooseUpgrade() {
        MyWorkspace myWorkspace = new MyWorkspace(driver);
        String Upgrade = myWorkspace.GetUpgrade();
        myWorkspace.ClickUpgrade();
        Assert.assertEquals("Upgrade ⭐", Upgrade);
    }

    @Story("")
    @Issue("")
    @Test(description = "choose in upgrade")
    public void tc03_chooseTypeUpgrade() {
        ChooseASubscriptionThatSuitsYou chooseSuitable = new ChooseASubscriptionThatSuitsYou(driver);
        chooseSuitable.chooseMonthlyOrYearly("monthly");
        String Type = chooseSuitable.GetChooseTypeUpgrade();
        chooseSuitable.typeUpgrade("Get Business monthly");
        Assert.assertEquals(Type, "Get Business monthly");

    }

    @Story("")
    @Issue("")
    @Test(description = "The details of the means of payment, and personal details should be stated")
    public void tc04_FillInDetails() {
        YouAreAlmostOnStarter starter = new YouAreAlmostOnStarter(driver);
        starter.yourPaymentDetails1("Haim Navon", "4580-0303-3333-8353", "1226", "333", "ert54v6");
        starter.yourBillingDetails1("Haim", "Navon", "PHA", "p-azoulay@gmail.com", "052-2345672", "Rakefet", "15",
                "99000", "bait shemesh", "IL");
//		starter.yourPaymentDetails(paymentDetails);
//		starter.yourBillingDetails(BillingDetails);
        starter.yourOrderSummary();
        String payment = "Your order summary";
        Assert.assertTrue(starter.yourOrderSummaryy().contentEquals(payment));
        AllureAttachment.attachURL("https://www.involve.me/");
    }
}
