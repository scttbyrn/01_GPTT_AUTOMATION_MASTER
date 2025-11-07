package TestComponents;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasePage {
	
	
	public UiAutomator2Options options;
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public LandingPage landingPage;
	

	public AndroidDriver InitializeDriver() throws MalformedURLException, URISyntaxException {
		
		/*Setup automatically connect on appium server*/
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//scottbyron.escueta//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();

		/*Setup uiAutomator2*/
		String unifiedApp = "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-x86_64-debug.apk";
		String GPTTApp = "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-dev-release-20251023_1420.apk";
		
		options = new UiAutomator2Options();
		options.setDeviceName("TestAppiumGPTT");
		options.setApp(unifiedApp); //nativeApp
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
			
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchingPage() throws MalformedURLException, URISyntaxException {
		
		driver = InitializeDriver();
		landingPage = new LandingPage(driver);
		
		return landingPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.quit();
		service.start();
		
	}
	
	/**Get ScreenShots**/
	public String getScreenshot(String testCaseName, AndroidDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	
	

}
