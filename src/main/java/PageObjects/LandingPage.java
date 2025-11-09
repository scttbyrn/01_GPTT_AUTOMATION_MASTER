package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import abstractMethodUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends AndroidActions {
	
	AppiumDriver driver;
	
	public LandingPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
//	@AndroidFindBy
//	private WebElement nameField;
	
	
	public void setupGetStartedOTPMPIN() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Get Started']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Skip']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in with Mobile Number\"]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index= '2']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index= '2']")).sendKeys("9274119438");
		driver.findElement(By.xpath("//android.widget.EditText[@index= '4']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index= '4']")).sendKeys("Testing123!");
//		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc = 'CONTINUE']")).click();
		
		//OTP
		driver.findElement(By.xpath("//android.view.View[@content-desc = '1']")).click();
		driver.findElement(By.xpath("(//android.view.View[@content-desc = '1'])[2]")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc = '2']")).click();
		driver.findElement(By.xpath("(//android.view.View[@content-desc = '2'])[2]")).click();
		
//		Thread.sleep(15);
//	    int[] otp = {1, 1, 2, 2};
//
//		for (int otps : otp) {
//			driver.findElement(By.xpath("//android.view.View[@content-desc = '"+otps+"']")).click();
//			Thread.sleep(5);
//        }
		
		//MPIN
		driver.findElement(By.xpath("//android.view.View[@content-desc = '2']")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc = '5']")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc = '8']")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc = '0']")).click();
		
	}
	
	public void errorScenario() {
		

		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Get Started']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Skip']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in with Mobile Number\"]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index= '2']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index= '2']")).sendKeys("9274119438");
		String actualResult = driver.findElement(By.xpath("//android.widget.EditText[@index= '2']")).getText();
		String expectedResult = "QWERTYUIOP";
		System.out.println(expectedResult);
		Assert.assertEquals(actualResult,expectedResult, "Something went wrong!");
		
	}
	
	public void startActivity() {
		
		
		Activity activity = new Activity ("com.globalpinoytravel.app", "com.globalpinoytravel.app.MainActivity");  
		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent", "com.globalpinoytravel.app/com.globalpinoytravel.app.MainActivity"));
	}
	

	

	
	

}
