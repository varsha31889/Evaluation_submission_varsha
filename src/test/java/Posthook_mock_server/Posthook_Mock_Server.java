package Posthook_mock_server;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Posthook_Mock_Server {
	
//  String accessToken = "";     


public void JSONPlaceholder() {
		
		Response rep = given().get("https://posthook-api.mock.beeceptor.com");
		int statusCodevar = rep.getStatusCode();
		Assert.assertEquals(statusCodevar, 200);
		
	}


@Test  (enabled = false)
public void Schedule_a_Hook () {
	
	JSONObject js = new JSONObject();

	
	given().body(js.toJSONString()).when().post("https://posthook-api.mock.beeceptor.com/v1/hooks").then().statusCode(200).log().all();		

 }
@Test (enabled = false)
public void Get_Hooks () {
	given().get("https://posthook-api.mock.beeceptor.com/v1/hooks").then().statusCode(200).log().all();
	
}

@Test (enabled = true)
public void hook_id () {              //6ab4d4d5-4767-452d-b72f-6ec40562b27e
	given().get("https://posthook-api.mock.beeceptor.com/v1/hooks/6ab4d4d5-4767-452d-b72f-6ec40562b27e").then().statusCode(200).log().all();
	
  }
 //   6ab4d4d5-4767-452d-b72f-6ec40562b27e

 @Test (enabled = true)
 
 public void delete() {
	 
	 JSONObject js = new JSONObject();

	 given().body(js.toJSONString()).when().delete("https://posthook-api.mock.beeceptor.com/v1/hooks/6ab4d4d5-4767-452d-b72f-6ec40562b27e").then().statusCode(200).log().all();	
	 
 }
 
 @Test  (enabled = true)
	public void put () {
		
		JSONObject js = new JSONObject();
		
		js.put("name", "updated-project");
		js.put("domain", "api.example.com");   
		js.put("headerAuthorization", "");
		js.put("minRetries", 1);
		js.put("retryDelaySecs", 5);
		
		given().body(js.toJSONString()).when().put("https://posthook-api.mock.beeceptor.com/v1/projects/").then().statusCode(200).log().all();	
	
	}
 
}




