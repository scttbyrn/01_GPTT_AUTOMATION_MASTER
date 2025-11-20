package testRuns;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import testComponents.BasePage;
import testComponents.TestAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TestingAPI extends BasePage{
	
	
//    @Test
    public void apitestscenario()  {
    	
    	testAPI = new TestAPI();
        
    	testAPI.apiUnifiedPostGenerateToken();
    	testAPI.apiUnifiedPostFetchAccount();
        

    }
    
    
    
}
