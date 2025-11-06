package TestRuns;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import TestComponents.BasePage;
import TestComponents.TestAPI;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestScenario extends BasePage {
	
	//SCOTTBYRON
	
	LandingPage landingpage;
	TestAPI apitest  = new TestAPI();
	
	String gpttAPI = "/usr/v1/customer/user";
	String targetStartPoint = "/User";
	


	@Test(groups = {"Regression"})
	public void TC1_PassedScenario() throws InterruptedException{

		landingpage = new LandingPage(driver);
		landingpage.setupGetStartedOTPMPIN();

	}

	@Test(groups = {"Regression"})
	public void TC2_ErrorScenario(){

		landingpage = new LandingPage(driver);
		landingpage.errorScenario();
	}

	@Test(groups = {"Regression"})
	public void TC3_PassedAPI(){

		apitest.getAPI(targetStartPoint);
		apitest.postAPI(targetStartPoint);
		apitest.retrieveDataAPI(targetStartPoint);
		apitest.validateRetrieveDataAPI(targetStartPoint);

	}

	@Test(groups = {"Regression"})
	public void TC4_FailedAPI(){

		baseURI = "http://localhost:3000";
		given().get(targetStartPoint);

		int size = given().get(targetStartPoint).jsonPath().getList("$").size();
		String lastId = given().get(targetStartPoint).jsonPath().getString("[" + (size - 1) + "].id");
		System.out.println("Sending API to startpoint to endpoint by ID: " +lastId);

		given().get(targetStartPoint).then().body("["+ (size - 1) +"].id", equalTo("asdasdasd"));

	}


}
