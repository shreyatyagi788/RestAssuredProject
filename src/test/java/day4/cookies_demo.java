package day4;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class cookies_demo {
	
	@Test(priority=1)
	void testCookie() {
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC", "ARSKqsKt5gFDHgMN2DhXDx8qYthPXClq-0oHtjpPumL15XaYYZxC_9Xr2cE")
			.log().all();
		
	}
	@Test(priority=2)
	void getCookie() {
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		String cookieVal=res.getCookie("AEC");
		System.out.println("value of cookie is====>"+cookieVal);
	}
	@Test(priority=3)
	void getAllCookie() {
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		Map<String,String> cookiesVal = res.getCookies();
		
		for(String k: cookiesVal.keySet()) {
			String cookieVal=res.getCookie(k);
			System.out.println(k+"       "+cookieVal);
		}
		
	}

}
