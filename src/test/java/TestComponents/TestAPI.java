package testComponents;

//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAPI {


	public String token;

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

	public void apiUnifiedPostFetchAccount() {
		// Set base URI
		baseURI = "https://api.unified.ph/";

		// Prepare request headers
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", token);
		headers.put("Content-Type", "application/x-www-form-urlencoded");  // Set form data content type

		// Prepare request body (form parameters)
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String formattedDateTime = currentDateTime.format(formatter);

		Map<String, String> params = new HashMap<>();
		params.put("customerid", "CUS000001");
		params.put("rrn", "scott" +formattedDateTime);

		// Send POST request with form data and log details
		System.out.println("1st Log");
		Response response = given()
				.headers(headers)
				.formParams(params)  // Send form parameters
				.log().all()  // Log request details (headers, body, etc.)
				.when()
				.post("ups_network_service_stg/fetch_account")
				.then()
				.statusCode(200)
				.log().all()  // Log response details (status, body, etc.)
				.extract().response();

		List<Map<String, Object>> list = response.jsonPath().getList("data");

		Map<String, Object> account = list.stream()
		        .filter(item -> "CUS000001".equals(item.get("customerid")))
		        .findFirst()
		        .orElseThrow(() -> new RuntimeException("Customer not found"));

		String customerId = account.get("customerid").toString();
		float networkIncome = Float.parseFloat(account.get("network_income").toString());
		float virtualVisa =  Float.parseFloat(account.get("virtualvisa_fund").toString());

		System.out.println("Customer: " + customerId);
		System.out.println("Network Income: " + networkIncome);
		System.out.println("Virtual Visa Fund: " + virtualVisa);

		//        // Validate status code and log response body
		//        System.out.println("2nd Log");
		//        response.then().statusCode(200).log().all(); // This will log the response if status is 200
		//
		//        // Optionally, log the response body directly for more clarity
		//        System.out.println("3rd Log");
		//        String responseBody = response.getBody().asString();
		//        System.out.println("Response Body: " + responseBody);

	}

	public String apiUnifiedPostGenerateToken() {
		baseURI = "https://api.unified.ph";

		Map<String, String> params = new HashMap<>();
		params.put("regcode", "F8149922");
		params.put("path", "/ups_network_service_stg/credit_fund");

		Response response = given()
				.contentType("application/x-www-form-urlencoded")
				.formParams(params)
				.log().all()
				.when()
				.post("/ups_network_service_stg/generate_token")
				.then()
				.statusCode(200)
				.log().all()
				.extract().response();

		// Extract only the token
		token = response.jsonPath().getString("data.token");

		System.out.println("Extracted Token: " + token);

		return token;
	}






}
