package abstractMethodUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {

	AppiumDriver driver;
	public AndroidActions(AppiumDriver driver) {

		this.driver = driver;
	}
	
	public boolean isElementPresent(By locator) {
	    try {
	        driver.findElement(locator);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	
	public void clickButton (WebElement element) {
		
		element.click();
	
	}

}
