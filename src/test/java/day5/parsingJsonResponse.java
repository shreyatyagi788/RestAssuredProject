package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

public class parsingJsonResponse {
	//Approach 1
	@Test(priority=1)
	void testSmallJsonResponse() {
		given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/colourbook")
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.log().all()
			.body("[3].bookname",equalTo("rrr"));

		
	}
	@Test(priority=2)
	void testLargeJsonResponse() {
		
		//Approach 2
		
		Response res = given()
		
		.when()
			.get("http://localhost:3000/colourbook");
		
		Assert.assertEquals(res.getStatusCode(),200); //validation 1
		
		String bookName = res.jsonPath().get("[3].bookname").toString();
		
		Assert.assertEquals(bookName, "rrr"); //validation 2
		
		JSONArray jp = new JSONArray(res.asString());
		int size = jp.length();
		System.out.println("length of array is :"+size);
		//int s = jp.getInt("data.size()");
		//System.out.println("length of array is :"+s);
		
//		List<String> data = jp.getList("bookname");
//		String data = jp.getJSONObject(0).getString("bookname");
//		System.out.println("data is :"+data);
		boolean status = false;
		for(int i=0;i<size;i++) {
			String item = jp.getJSONObject(i).get("bookname").toString();
			System.out.println(item);

			if(item.equals("rrr")) {
				status = true;
				break;
			}
			
		}
//		Assert.assertEquals(data, "xyz");
		Assert.assertEquals(status, true);
		}
//		.then()
//			.statusCode(200);
		


}
