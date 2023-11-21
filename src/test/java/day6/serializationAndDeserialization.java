package day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serializationAndDeserialization {
	//@Test
	void serialization() throws JsonProcessingException {
		// serilization means converting pojo(or any java object) to json
		students data = new students();
		data.setName("nishkarsh");
		data.setCountry("india");
		String courseArr[]= {"mysql","python"};
		data.setCourses(courseArr);
	    //converting pojo to json.
		ObjectMapper objmapper = new ObjectMapper();
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
	}
	
	@Test
	void deserilization() throws JsonMappingException, JsonProcessingException
	{
		//deserilization means extracting java object from json.
		String jsonData = "{\r\n"
				+ "  \"name\" : \"nishkarsh\",\r\n"
				+ "  \"country\" : \"india\",\r\n"
				+ "  \"courses\" : [ \"mysql\", \"python\" ]\r\n"
				+ "}";
		//converting json data to pojo.
		ObjectMapper objMapper = new ObjectMapper();
		students stupojo=objMapper.readValue(jsonData, students.class);
		System.out.println(stupojo.getName());
		System.out.println(stupojo.getCountry());
		System.out.println(stupojo.getCourses()[0]);
		System.out.println(stupojo.getCourses()[1]);

		System.out.println(stupojo);

		
		}

}
