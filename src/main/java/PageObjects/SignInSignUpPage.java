package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import abstractMethodUtils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInSignUpPage extends AndroidActions {

	AppiumDriver driver;

	public SignInSignUpPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	//Input login with mobile number Page:
		@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Log in with Mobile Number']")
		private WebElement logInWithMobileNumber_Button;
	
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[1]")
		private WebElement inputMobileNumber_TextBox;
		
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[2]")
		private WebElement inputPassword_TextBox;
		
		@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='CONTINUE']")
		private WebElement continue_Button;
	
	//Forgot Password Page:
		@AndroidFindBy(xpath = "//android.view.View[@content-desc='Forgot Password?']")
		private WebElement forgotPassword_Button;
		
		@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Send Verification Code']")
		private WebElement sendVerifiactionCode_Button;
		
		@AndroidFindBy(xpath = "//android.view.View[@content-desc='Sign In']")
		private WebElement signIn_Button;

	//Input LogIn with Email Page:
		@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Log in with Email']")
		private WebElement logInWithEmail_Button;
		
		@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[1]")
		private WebElement inputEmail_TextBox;
		
	//SignUp Page:
		@AndroidFindBy(xpath = "//android.view.View[@content-desc='Don't have an account? Sign Up']")
		private WebElement signUp_Button;
		
		@AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
		private WebElement affiliateCode_TextBox;
		
		@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
		private WebElement next_Button;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	


}
