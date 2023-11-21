package day7;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class createUser {
	@Test
	void testCreateUser(ITestContext context) {
	
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "416bd91bfc5fc3dbb8965c95ccb8fe97f675f9cf73d72d5c7504cc42d16fd9fd";
		int id = given()
			.header("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().get("id");
		System.out.println("generated id is:"+id);
		context.getSuite().setAttribute("user_id", id);
	}
}
