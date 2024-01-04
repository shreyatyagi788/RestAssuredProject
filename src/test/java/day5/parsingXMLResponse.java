package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class parsingXMLResponse {
	
	@Test
	void testXMLResponse() {
		//method1
		/*given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type",equalTo("application/xml; charset=utf-8"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].id", equalTo("11133"))
			.log().all();*/
		
	
		
		
		//method2-need to follow this if we need to parse the whole xml response
		/*Response res = given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		String id = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].id").toString(); //if we need to convert single data into string then we use 'toString()' method. 
		Assert.assertEquals(id, "11133");*/
		
		Response res=given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xp = new XmlPath(res.asString()); // if we want to covert whole response into string format then we use 'asString()' method.
		/*
		//verifying total no. of travellers.
		List<String> travellers = xp.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);*/
		
		//verify traveller name is present in response or not.
		
		List<String> travellerNames = xp.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		for(String travellerName:travellerNames) {
			System.out.println(travellerName);
			if(travellerName.equals("Ashor")) {
				status=true;
				break;
			}
			
		}
		
		Assert.assertEquals(status, true);

	}
}