import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook(isbn,aisle))
		.when()
		.post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
	}
	
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"five","0980"},{"hive","0980"},{"dive","0980"}};
	}
	

}
