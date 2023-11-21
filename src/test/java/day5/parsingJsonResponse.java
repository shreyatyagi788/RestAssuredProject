package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

public class parsingJsonResponse {
	@Test
	void testJsonResponse() {
		
		Response res = given()
		
		.when()
			.get("http://localhost:3000/colourbook");
		
		JSONArray jp = new JSONArray(res.asString());
		//int s = jp.getInt("data.size()");
		//System.out.println("length of array is :"+s);
		
//		List<String> data = jp.getList("bookname");
		String data = jp.getJSONObject(0).getString("bookname");
//		System.out.println("data is :"+data);
//		boolean status = false;
//		for(String item:data) {
//			if(item.equals("xyz")) {
//				status = true;
//				break;
//			}
//			
//		}
		Assert.assertEquals(data, "xyz");
		}
//		.then()
//			.statusCode(200);
		


}
