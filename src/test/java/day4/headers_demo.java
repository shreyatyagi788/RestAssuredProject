package day4;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.http.Header;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class headers_demo {
	@Test(priority=1)
	void testHeaders() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip");
		
	}
	@Test(priority=2)
	void getSingleHeader() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
		String headerVal=res.getHeader("Content-Type");
		System.out.println("value of content-type header is:  "+headerVal);
			
//		.then()
//			.header("Content-Type", "text/html; charset=ISO-8859-1")
//			.and()
//			.header("Content-Encoding", "gzip");
		
	}
	@Test(priority=3)
	void getMultipleHeaders() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
		Headers allheaders=res.getHeaders();
		for(Header hd:allheaders) {
			System.out.println(hd.getName()+"            "+hd.getValue());
		}
			
	}

}
