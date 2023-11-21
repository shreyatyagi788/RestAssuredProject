package day7;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class updateUser {
	
	@Test
	void testUpdateUser(ITestContext context) {
		
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "active");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		String bearerToken = "416bd91bfc5fc3dbb8965c95ccb8fe97f675f9cf73d72d5c7504cc42d16fd9fd";
		given()
			.header("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()	
			.statusCode(200)
			.log().all();
		
	}

}
