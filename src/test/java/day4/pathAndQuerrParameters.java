package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class pathAndQuerrParameters {
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void testQueryAndPathParameters() {
		
		given()
			.queryParam("page", 2)
			.queryParam("id", 5)
			//for every path we need different variable, we can not specify the whole path in one variable.
			.pathParam("mypath1", "api")
			.pathParam("mypath2", "users")
		.when()
			//query parameters we don't need to specify in get method, they automatically sent with the req.
			//.get("https://reqres.in/{mypath1}/{mypath2}")
			.get("https://reqres.in/"+"{mypath1}"+"/"+"{mypath2}")

		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
