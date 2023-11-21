package day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class jsonSchemaValidation {
	
	@Test
	void jsonSchemaValidation() {
		given()
		.when()
			.get("http://localhost:3000/colourbook")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("body.json"));
		
	}

}
