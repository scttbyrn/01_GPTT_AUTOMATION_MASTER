package TestRuns;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import TestComponents.TestAPI;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class testingAPI {

	TestAPI apitest = new TestAPI();
	
//	@Test
	public void apitestscenario() {
		
//		String loginAPI = "/usr/v1/customer/verify-otp";
		baseURI = "https://unifiedapi.ecashpay.com";
		
	
		Headers headers = new Headers(
			    new Header("auth_token", "$2y$10$QcgQcvNpgHfGkq3DoQWRdef611po/H5SFcGY4ONSz0fNfFdkw8efO"),
			    new Header("authentication", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPMHI0TDV2S0RyaWxONlJ6dXFUbm1yNURhUHFxblJhZSJ9.De_DTaOqZkjxVC5Km9j7c-kJ_a4KUhBMlKPDPAQixT4"),
			    new Header("platform", "android"),
			    new Header("X-Consumer-Custom-ID", "CUS001750677417"),
			    new Header("Company_ID", "2")
			);
		
		
		given().headers(headers).when().get("/usr/v1/customer/verify-otp").then().statusCode(200).log().body();
		
		
		System.out.println("TestAPI");
		
	}
	
}
