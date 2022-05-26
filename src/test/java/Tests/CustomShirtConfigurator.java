package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.ChooseProjectType;
import PageObject.CustomShirtConfiguratorPage;
import PageObject.LoginPage;
import PageObject.MyWorkspace;
import PageObject.Templates;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import utilities.AllureAttachment;

public class CustomShirtConfigurator extends BaseTest {
	private String[] ItalianShirt = { "100% pure cotton Purreal", "short sleeve", "angled double button", "Slim",
			"pointy", "M" };
	private String yourShirt = "Your custom shirt is almost ready";

	@Story("")
	@Issue("")
	@Test(description = "Sign in with my name details")
	public void tc01_OpenLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		Assert.assertEquals(loginPage.MyLogin(), "Haim-a");
	}

	@Story("")
	@Issue("")
	@Test(description = "Click on START")
	public void tc02_startToProject() {
		MyWorkspace workspace = new MyWorkspace(driver);
		String Start = workspace.GetStart();
		workspace.StartProject();
		Assert.assertEquals(Start, "Start");
	}

	@Story("")
	@Issue("")
	@Test(description = "Choose my project type")
	public void tc03_OpeningPaymentFormPage() {
		ChooseProjectType choosePro = new ChooseProjectType(driver);
		String Payment = choosePro.PaymentFormTypeProject();
		choosePro.ChooseProject("Payment Form");
		AllureAttachment.TextAttachment("Enter a payment form template");
		Assert.assertEquals("Payment Form", Payment);
	}

	@Story("")
	@Issue("")
	@Test(description = "Choose my projact")
	public void tc04_ChooseYourShirtPage() {
		Templates template = new Templates(driver);
		String Shirt = template.GetCustomShirt();
		template.ChooseTemplate("Custom Shirt Configurator");
		Assert.assertEquals(Shirt, "Custom Shirt Configurator");
	}

	@Story("")
	@Issue("")
	@Test(description = "Dimensions of the garment")
	public void tc05_ShirtDimensionsPage() {
		CustomShirtConfiguratorPage Shirt = new CustomShirtConfiguratorPage(driver);
		Shirt.italianShirt(ItalianShirt);
		Assert.assertTrue(Shirt.yourShirtIsReady().contains(yourShirt));
	}
}
