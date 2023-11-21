package day7;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class getUser {
	
	@Test
	void testGetUser(ITestContext context) {
		
		String bearerToken = "416bd91bfc5fc3dbb8965c95ccb8fe97f675f9cf73d72d5c7504cc42d16fd9fd";
		
		int id = (int) context.getSuite().getAttribute("user_id");
		given()
			.header("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
