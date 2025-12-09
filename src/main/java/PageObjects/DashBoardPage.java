package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import abstractMethodUtils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashBoardPage extends AndroidActions {
	
	AppiumDriver driver;
	
	public DashBoardPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	//Header:
		@AndroidFindBy(xpath = "(//android.view.View)[7]")
		private WebElement oneEyeIcon_Button;
		
		@AndroidFindBy(xpath = "(//android.view.View)[6]")
		private WebElement fundValue_Button;
		
		@AndroidFindBy(xpath = "//android.view.View[@content-desc= 'Add Fund']")
		private WebElement addFund_Button;
		
	//Body:
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Buy Load']")
		private WebElement buyLoad_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Pay Bills']")
		private WebElement payBills_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cash In']")
		private WebElement cashIn_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cash Out']")
		private WebElement cashOut_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Insurance']")
		private WebElement insurance_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Remittance']")
		private WebElement remittance_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Network']")
		private WebElement network_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Flights']")
		private WebElement flights_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Hotels']")
		private WebElement hotels_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Travel and Tours']")
		private WebElement travelAndTours_Button;
		
		@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Travel Inquiry']")
		private WebElement travelInquiry_Button;
		
	//Footer:
		@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Home')]")
		private WebElement home_Button;
		
		@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Notification')]")
		private WebElement notification_Button;
		
		@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'QR Send')]")
		private WebElement qrSend_Button;
		
		@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Events')]")
		private WebElement events_Button;
		
		@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Profile')]")
		private WebElement profile_Button;
		
		
		
		public void tapBodyTransaction(String transaction) {//Optimize to choose to select transaction:
			
			switch(transaction) {
				case "Buy Load":
					clickButton(buyLoad_Button);
					break;
					
				case "Pay Bills":
					clickButton(payBills_Button);
					break;
					
				case "Cash In":
					clickButton(cashIn_Button);
					break;
					
				case "Cash Out":
					clickButton(cashOut_Button);
					break;
					
				case "Insurance":
					clickButton(insurance_Button);
					break;
					
				case "Remittance":
					clickButton(remittance_Button);
					break;
					
				case "Network":
					clickButton(network_Button);
					break;
					
				case "Flights":
					clickButton(flights_Button);
					break;
					
				case "Hotels":
					clickButton(hotels_Button);
					break;
					
				case "Travel and Tours":
					clickButton(travelAndTours_Button);
					break;
					
				case "Travel Inquiry":
					clickButton(travelInquiry_Button);
					break;
					
			}
		}
			
			
			public void tapFooterIcon(String transaction) {//Optimize to choose to select transaction:
				
				switch(transaction) {
					case "Buy Load":
						clickButton(home_Button);
						break;
						
					case "Pay Bills":
						clickButton(notification_Button);
						break;
						
					case "Cash In":
						clickButton(qrSend_Button);
						break;
						
					case "Cash Out":
						clickButton(events_Button);
						break;
						
					case "Insurance":
						clickButton(profile_Button);
						

				}
		
				
		}
		
		
		
		
		
	
	

}
