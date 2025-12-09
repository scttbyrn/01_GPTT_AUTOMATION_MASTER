package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import abstractMethodUtils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends AndroidActions {
	
	AppiumDriver driver;
	
	public ProfilePage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Customer Id')]")
	private WebElement customerInfo_Text;
	
	
	
	public void getCustomerInfo() {
		String custometInfo = customerInfo_Text.getText();
		System.out.println(custometInfo);
		
	}
	
	

}
