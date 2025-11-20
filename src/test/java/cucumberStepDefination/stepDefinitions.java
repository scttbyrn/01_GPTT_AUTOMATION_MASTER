package cucumberStepDefination;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import testComponents.BasePage;

public class stepDefinitions extends BasePage {



	@Given("the user is on the Cash In or Cash Out screen")
	public void the_user_is_on_the_Cash_In_or_Cash_Out_screen() throws MalformedURLException, URISyntaxException, InterruptedException {

		initializePage();
		landingPage.setupGetStartedOTPMPIN();
		quitApp();

	}

	@When("the system fetches account details via the fetch_account endpoint")
	public void the_system_fetches_account_details_via_the_fetch_account_endpoint() throws MalformedURLException, URISyntaxException, InterruptedException {

		initializePage();
		landingPage.setupGetStartedOTPMPIN();
		quitApp();

	}
	
	
	
}
