package day7;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {
	@Test
	void deleteUser(ITestContext context) {
		
		String bearerToken = "416bd91bfc5fc3dbb8965c95ccb8fe97f675f9cf73d72d5c7504cc42d16fd9fd";

		int id = (int) context.getSuite().getAttribute("user_id");
		given()
			.header("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
			
		
	}

}
