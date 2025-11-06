package AbstractMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.AndroidDriver;

public class Abstract {

	AndroidDriver driver;
	public Abstract(AndroidDriver driver) {

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

}
