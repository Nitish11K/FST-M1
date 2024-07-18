package examples;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import java.util.HashMap;
import java.util.Map;

        public class SpecificationTst {
		RequestSpecification requestSpec;
		ResponseSpecification responseSpec;
		int petId;
		
		@BeforeClass		
		public void setUp(){
			//Request Specification
			requestSpec = new RequestSpecBuilder().
					setBaseUri("https://petstore.swagger.io/v2/pet").
					addHeader("Content-Type", "application/json").
					build();
			// Response Specification
			responseSpec =	new ResponseSpecBuilder().	
					expectStatusCode(200).
					expectResponseTime(lessThanOrEqualTo(3000L)).
					build();
		}
		//POST https://petstore.swagger.io/v2/pet		
		@Test(priority = 1)			
		public void postRequest() {
		// create request body	
        Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 110);
		reqBody.put("name", "joey");
		reqBody.put("status", "alive");
		Response response	= given().spec(requestSpec).body(reqBody).when().post();	
		//Extract the pet id
		petId = response.then().extract().path("id");
		//Assertion
		response.then().spec(responseSpec).body("status", equalTo("alive"));
		}
		
		// GET https://petstore.swagger.io/v2/pet/{petId}
		@Test(priority = 2)				
		public void getRequest(){
				//create request body	
				given().spec(requestSpec).pathParam("petId",petId).						
				when().get("/{petId}").
				then().spec(responseSpec).body("status", equalTo("alive"));
				}		
		
		// DELETE https://petstore.swagger.io/v2/pet/{petId}
		@Test(priority = 3)				
		public void DeleteRequest(){
				// send request, get response
				given().spec(requestSpec).pathParam("petId",petId).						
				when().delete("/{petId}").
				then().spec(responseSpec).body("message", equalTo(""+petId));
		}		
	}

