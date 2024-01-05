package day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;


public class fileUploadAndDownload {
	
	@Test(priority=1)
	void testSingleFileUpload() {
		
		File myfile = new File("C:\\Users\\Aaryan\\Downloads\\shreyapythonfiles\\pdfText.txt");
		given()
			//.multiPart(myfile)
			.multiPart("file", myfile)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("fileName",equalTo("pdfText.txt"))
			.log().all();
	}
	
	//@Test(priority=2)
	void testMultipleFilesUpload() {
		
		File myfile1 = new File("C:\\Users\\Aaryan\\Downloads\\shreyapythonfiles\\api access token.txt");
		File myfile2 = new File("C:\\Users\\Aaryan\\Downloads\\shreyapythonfiles\\pdfText.txt");
		
		//File myfiles[] = {myfile1,myfile2};

		given()
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)
			//.multiPart("files",myfiles)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.statusCode(200)
			.body("[0].fileName",equalTo("api access token.txt"))
			.body("[1].fileName",equalTo("pdfText.txt"))
			.log().all();

	}
	
	@Test(priority=3)
	void testFileDownload() {
		
		given()
		
		.when()
			.get("http://localhost:8080/downloadFile/pdfText.txt")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
