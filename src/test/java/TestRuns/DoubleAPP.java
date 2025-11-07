package TestRuns;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.Test;

import PageObjects.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DoubleAPP {
	
	
	public UiAutomator2Options options;
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public LandingPage landingPage;
	
	@Test
	public void doublAPP() throws MalformedURLException, URISyntaxException {
		
		String unifiedApp = "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-x86_64-debug.apk";
		String GPTTApp = "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-dev-release-20251023_1420.apk";
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//scottbyron.escueta//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		
		options = new UiAutomator2Options();
		options.setDeviceName("TestAppiumGPTT");
		options.setApp(unifiedApp); //nativeApp
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		
		
		
//		options.setDeviceName("TestAppiumGPTT");
//		options.setApp(GPTTApp); //nativeApp
//		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}

}
