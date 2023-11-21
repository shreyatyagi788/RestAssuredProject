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
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].id", equalTo("11133"))
			.log().all();
		
	}*/
		
		//method2-need to follow this if we need to parse the whole xml response
		/*Response res = given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		String id = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].id").toString();
		Assert.assertEquals(id, "11133");*/
		
		Response res = given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xp = new XmlPath(res.asString());
		//verifying total no. of travellers.
		List<String> travellers = xp.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
	}
}
