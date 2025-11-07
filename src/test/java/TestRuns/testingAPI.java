package TestRuns;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class testingAPI {

    @Test
    public void apitestscenario() {
        // Set base URI
        baseURI = "https://api.unified.ph/";

        // Prepare request headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlMjU1ZWYxZGQ0ZDMwYzc4MmFhMDBiOWM5YmE2OWUwODc0YzdhOTg3NTUwMGM4NGIyY2YyZWJhN2I3YjE4YWIyIiwicmVnY29kZSI6IkY4ODAzNzM0IiwicGF0aCI6IlwvdXBzX25ldHdvcmtfc2VydmljZV9zdGdcL2ZldGNoX2FjY291bnQiLCJpYXQiOjE3NjIyNDcxOTAsImV4cCI6MTc2MjI1MDc5MH0.hCQs0zakteRzEoaegUbHgTTYVUk23Vux-UBBepQta6Y");
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

//        // Validate status code and log response body
//        System.out.println("2nd Log");
//        response.then().statusCode(200).log().all(); // This will log the response if status is 200
//
//        // Optionally, log the response body directly for more clarity
//        System.out.println("3rd Log");
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body: " + responseBody);
        
    }
    
}
