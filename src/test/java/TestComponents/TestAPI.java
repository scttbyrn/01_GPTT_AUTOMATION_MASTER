package TestComponents;

//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class TestAPI {
	
	


	public static String getAPI(String target) { //Fetching data
		
//		baseURI = "https://unifiedapi.ecashpay.com"; //GPTT Base URI
		
		baseURI = "http://localhost:3000";
		given().get(target).then().statusCode(200).log().all();

		return baseURI;
	}


	public static void postAPI(String target) { //Input new data

		JSONObject request = new JSONObject(); // Object for inputing JSON Data FIle

		request.put("name", "Kobengot");
		request.put("age", 30);
		request.put("email", "alice@example.com");
		request.put("isActive", true);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().post(target)
		.then().statusCode(201);

	}

	public static void putAPI() { //Update existing entire API data

		JSONObject request = new JSONObject(); // Object for inputing JSON Data FIle

		request.put("name", "Scotty");
		request.put("age", 30);
		request.put("email", "alice@example.com");
		request.put("isActive", true);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().put("/User/6305")
		.then().statusCode(200);

	}

	public static void patchAPI() { //Update using specific API data

		JSONObject request = new JSONObject(); // Object for inputing JSON Data FIle

		request.put("isActive", false);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().patch("/User/6305")
		.then().statusCode(200);

	}

	public static void deleteAPI() { //Deleting API data

		given().when().delete("/User/6305").then().statusCode(200);


	}

	public static void retrieveDataAPI(String target) { //getting specific API data using getString();

		given().get("/User").then().statusCode(200).log().all();
		int size = given().get(target).jsonPath().getList("$").size();

		String lastId = given().get(target).jsonPath().getString("[" + (size - 1) + "].id");

		System.out.println("Trace last posted API by ID: " +lastId);


	}

	public static void validateRetrieveDataAPI(String target) { //validate retrieve data; this can be startpoint or endpoint scenario.

		given().get(target);

		int size = given().get(target).jsonPath().getList("$").size();
		String lastId = given().get(target).jsonPath().getString("[" + (size - 1) + "].id");

		System.out.println("Sending API to startpoint to endpoint by ID: " +lastId);
		given().get("/User").then().body("["+ (size - 1) +"].id", equalTo(lastId));

	}
	
	public void unifiedAPI() {
		
		
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
