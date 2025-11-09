package testRuns;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.LandingPage;
import testComponents.BasePage;
import testComponents.TestAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestScenario extends BasePage {
	
	//DEVELOPMENT AREAs:
	
	LandingPage landingpage;
	TestAPI apitest  = new TestAPI();
	
	String gpttAPI = "/usr/v1/customer/user";
	String targetStartPoint = "/User";
	
	
	@Test(groups = {"Regression"})
	public void TC1_PassedScenario() throws InterruptedException{

		landingpage = new LandingPage(driver);
		landingpage.setupGetStartedOTPMPIN();
		
//		activity = new Activity ("com.unifiedv2", "com.unifiedv2.MainActivity");  
//		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent", "com.unifiedv2/com.unifiedv2.MainActivity"));
		
		

	}

	@Test(groups = {"Regression"})
	public void TC2_ErrorScenario() throws InterruptedException{

		landingpage = new LandingPage(driver);
//		landingpage.setupGetStartedOTPMPIN();
		landingpage.errorScenario();
		
	}
//
//	@Test(groups = {"Regression"})
//	public void TC3_PassedAPI(){
//
//		apitest.getAPI(targetStartPoint);
//		apitest.postAPI(targetStartPoint);
//		apitest.retrieveDataAPI(targetStartPoint);
//		apitest.validateRetrieveDataAPI(targetStartPoint);
//
//	}
//
//	@Test(groups = {"Regression"})
//	public void TC4_FailedAPI(){
//
//		baseURI = "http://localhost:3000";
//		given().get(targetStartPoint);
//
//		int size = given().get(targetStartPoint).jsonPath().getList("$").size();
//		String lastId = given().get(targetStartPoint).jsonPath().getString("[" + (size - 1) + "].id");
//		System.out.println("Sending API to startpoint to endpoint by ID: " +lastId);
//
//		given().get(targetStartPoint).then().body("["+ (size - 1) +"].id", equalTo("asdasdasd"));
//
//	}
	


}
