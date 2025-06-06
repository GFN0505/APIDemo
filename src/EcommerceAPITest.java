import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;

import static io.restassured.RestAssured.*;

import java.io.File;

public class EcommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("anshika@gmail.com");
		loginRequest.setUserPassword("Iamking@000");
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		String token = loginResponse.getToken();
		System.out.println(loginResponse.getUserId());
		String userId = loginResponse.getUserId();
		
		
		//Add Product
		RequestSpecification addProductBasereq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();
		
		RequestSpecification reqAddProduct = given().log().all().spec(addProductBasereq).param("productName", "Fav Gucci").param("productAddedBy", userId)
		.param("productCategory", "fashion").param("productSubCategory", "shirts").param("productPrice", "2500")
		.param("productDescription", "Testing").param("productFor", "men").multiPart("productImage", new File("//Users//godsfavournwoko//Downloads//shoe.jpeg"));
		
		String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(addProductResponse);
		String productId = js.get("productId");

	}

}
