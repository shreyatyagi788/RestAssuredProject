package day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import day3.pojo_postRequest;
//import io.restassured.http.ContentType;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class waysToCreatePostRequestBody {
	int id;
	
	//post request body using hashmap.
//	@Test(priority = 1)
//	void testPostUsingHashMap() {
//		HashMap data = new HashMap();
//		data.put("name", "mini");
//		data.put("country", "usa");
//		
//		String courseArr[] = {"C","C++"}; 
//		data.put("courses", courseArr);
//		
//		id = given()
//			.contentType("application/json")
//			.body(data)
//		.when()
//			.post("http://localhost:3000/students")
//			.jsonPath().getInt("id");
////		.then()
////			.statusCode(201)
////			.body("name",equalTo("mini"))
////			.body("country",equalTo("usa"))
////			.body("courses[0]", equalTo("C"))
////			.body("courses[1]",equalTo("C++"))
////			.header("Content-Type","application/json; charset=utf-8")
////			.log().all();
//		
//	}
	@Test(priority=2)
	void testDelete() {
		given()
		.when()
			.delete("http://localhost:3000/students/3")
		.then()
			.statusCode(200)
			.log().all();
	}
//	
//	//post request body using org.json library.
//		@Test(priority = 1)
//		void testPostUsingOrgJsonLibrary() {
//			JSONObject data = new JSONObject();
//			data.put("name","ayu");
//			data.put("country", "India");
//			String coursesArr[] = {"python","ruby"};
//			data.put("courses", coursesArr);
//			
//			id = given()
//				.contentType("application/json")
//				.body(data.toString())
//			.when()
//				.post("http://localhost:3000/students")
//				.jsonPath().getInt("id");
////			.then()
////				.statusCode(201)
////				.body("name",equalTo("mini"))
////				.body("country",equalTo("usa"))
////				.body("courses[0]", equalTo("C"))
////				.body("courses[1]",equalTo("C++"))
////				.header("Content-Type","application/json; charset=utf-8")
////				.log().all();
//			
//		}
//	//post request body using POJO.
//		@Test(priority = 1)
//		void testPostUsingPOJO() {
//			pojo_postRequest data = new pojo_postRequest();
//			data.setName("nishkarsh");
//			data.setCountry("india");
//			String courseArr[]= {"mysql","python"};
//			data.setCourses(courseArr);
//		    given()
//				.contentType("application/json")
//				.body(data)
//			.when()
//				.post("http://localhost:3000/students")
//			
//			.then()
//				.statusCode(201)
//				.body("name",equalTo("nishkarsh"))
//				.body("country",equalTo("india"))
//				.body("courses[0]", equalTo("mysql"))
//				.body("courses[1]",equalTo("python"))
//				.header("Content-Type","application/json; charset=utf-8")
//				.log().all();
//		
//	}
//
	//post request body using external json file.
			@Test(priority = 1)
			void testPostUsingexternalJsonFile() throws FileNotFoundException {
				File f = new File(".\\body.json");
				FileReader fr = new FileReader(f);
				JSONTokener jt = new JSONTokener(fr);
				JSONObject data = new JSONObject(jt);
			    given()
					.contentType(ContentType.JSON)
					.body(data.toString())
				.when()
					.post("http://localhost:3000/students")
				
				.then()
					.statusCode(201)
					.body("name",equalTo("chinky"))
					.body("country",equalTo("usa"))
					.body("courses[0]", equalTo("c"))
					.body("courses[1]",equalTo("c++"))
					.header("Content-Type","application/json; charset=utf-8")
					.log().all();
			
		}


}
