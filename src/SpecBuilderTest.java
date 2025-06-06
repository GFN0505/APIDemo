import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.F4B;
import pojo.Meta;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		
		F4B p = new F4B();
		p.setAccount_number("100035129997");
		p.setAccount_bank("CIB");
		p.setAmount(random.nextInt(900));
		p.setNarration("Test");
		p.setReference("testRef "+random.nextInt(900));
		p.setCurrency("EGP");
		p.setBeneficiary_name("Flutterwave Test");
		
		// Create and set the meta data
        Meta meta = new Meta();
        meta.setSender("Cornelius");
        meta.setSender_id_expiry("2025-12-31");
        meta.setSender_id_number("123454");
        meta.setSender_date_of_birth("1990-01-01");
        meta.setSender_id_type("01");
        meta.setSender_city("naija");
        meta.setBeneficiary_address("123 mawin street");
        meta.setBeneficiary_id_number("ID5467833322222");
        meta.setIs_cash_pickup(false);
        meta.setTransfer_purpose("EPFAMT");
        meta.setRoutecode("");
        
        // Add the meta object to a list
        List<Meta> metaList = new ArrayList<>();
        metaList.add(meta);

        // Set the meta list to the main object
        p.setMeta(metaList);
        
		
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://f4b-v3-dashboard-staging-api.sandbox-flutterwave.com").addHeader("Authorization", "")
        .setContentType(ContentType.JSON).build();
        
        ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        
		
		RequestSpecification res = given().spec(req)
		.body(p); 
		
		Response response = res.when().post("/v3/transfers")
		.then().spec(resspec).extract().response();
		
		
		String responseString = response.asString();
		System.out.println(responseString);

	}

}
