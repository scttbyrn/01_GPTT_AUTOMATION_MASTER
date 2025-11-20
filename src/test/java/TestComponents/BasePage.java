package testComponents;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.LandingPage;

public class BasePage {


	public UiAutomator2Options options;
	public AppiumDriver driver;
	public AppiumDriverLocalService service;
	public LandingPage landingPage;
	public TestAPI testAPI;
	public Activity activity;


	public AppiumDriver InitializeDriver() throws MalformedURLException, URISyntaxException, InterruptedException {

		/*Setup automatically connect on appium server*/
//		service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("C://Users//scottbyron.escueta//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1")
//				.usingPort(4723)
//				.build();
//		service.start();
		
		

		//		/*Setup uiAutomator2*/
		String unifiedApp = "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-x86_64-debug.apk";
		String GPTTApp = "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-dev-release-20251106_1608.apk";
		String appActivity  = "com.globalpinoytravel.app.MainActivity";
		String appPackage = "com.globalpinoytravel.app";
		//		
		 this.options = new UiAutomator2Options();
		
		// BrowserStack options MUST be inside "bstack:options"
		 Map<String, Object> bstackOptions = new HashMap<>();
		 bstackOptions.put("userName", "scottbyronescuet_U6GLyK");
		 bstackOptions.put("accessKey", "Hxd9JCHWySzfyyKxwdSc");
		 
//		 bstackOptions.put("userName", System.getenv("BROWSERSTACK_USERNAME"));
//		 bstackOptions.put("accessKey", System.getenv("BROWSERSTACK_ACCESS_KEY"));
		 bstackOptions.put("deviceName", "Samsung Galaxy S23");
		 bstackOptions.put("osVersion", "13.0");
		 bstackOptions.put("projectName", "GPTT App");
		 bstackOptions.put("buildName", "Build 1");
		 bstackOptions.put("sessionName", "Sample Test");
		 bstackOptions.put("platformName", "Android");
		 bstackOptions.put("platformVersion", "13");


		 // Important: attach to options
		 options.setCapability("bstack:options", bstackOptions);

		 // Your app (must stay top-level)
		 options.setCapability("app", "bs://55d3ac99091167d054ac3c149c39c8f543b50d11");

		 // W3C caps (top-level)
		 options.setCapability("platformName", "Android");  // force override
		 options.setPlatformName("Android");
		 options.setAutomationName("UIAutomator2");

		 // Debug print (this will no longer be null)
		 System.out.println("Capabilities: " + options.toJson());

		 // Connect to BrowserStack hub
		 driver = new AndroidDriver(
		         new URI("https://hub.browserstack.com/wd/hub").toURL(),
		         options
		 );

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 return driver;

	}


	@BeforeMethod(alwaysRun=true)
	public LandingPage initializePage() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		System.out.println("Capabilities: "+options);
		
		System.out.println("BS USER = " + System.getenv("BROWSERSTACK_USERNAME"));
		System.out.println("BS KEY = " + System.getenv("BROWSERSTACK_ACCESS_KEY"));
		
		driver = InitializeDriver();
		landingPage = new LandingPage(driver);
//		landingPage.setupGetStartedOTPMPIN();
		
		return landingPage;

	}
	
	
	@AfterMethod(alwaysRun=true)
	public void quitApp() {

		if (driver != null) {
			driver.quit();
		}
//		service.stop();

	}
	


	/**-----------------------Get ScreenShots---------------------------**/
	public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);

		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";


	}




}
