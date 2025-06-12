import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.F4B;
import pojo.Meta;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class serializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://f4b-v3-dashboard-staging-api.sandbox-flutterwave.com";
		
		Random random = new Random();
		
		F4B p = new F4B();
		p.setAccount_number("1234567890");
		p.setAccount_bank("30");
		p.setAmount(random.nextInt(900));
		p.setNarration("AutomationTest");
		p.setReference("testRef "+random.nextInt(900));
		p.setCurrency("RWF");
		p.setBeneficiary_name("Jane Doe");
		p.setDebit_currency("NGN");
		
		// Create and set the meta data
        Meta meta = new Meta();
       
        meta.setBeneficiaryCountry("RW");
        meta.setAccountNumber("1234567890");
        meta.setFirstName("Jane");
        meta.setLastName("Doe");
        meta.setAddress("Kigali-Gatuna Rd, Kigali, Rwanda");
        meta.setBankName("ACCESS RWANDA");
        meta.setMobileNumber("25012345678");
        meta.setRoutingNumber("30");
        meta.setSender("Godsfavour Nwoko");
        meta.setSenderCountry("NG");
        meta.setBeneficiaryName("Jane Doe");
        meta.setSenderIdNumber("2345645");
        meta.setSenderIdType("01");
        meta.setSenderIdExpiry("2032-02-06");
        meta.setSenderCity("Lagos");
        meta.setBeneficiaryIdNumber("123456y5434");
        meta.setBeneficiaryAddress("Kigali-Gatuna Rd, Kigali, Rwanda");
        meta.setBeneficiaryMobileNumber("25012345678");
        meta.setSenderDateOfBirth("2006-02-22");
        meta.setBeneficiaryIdType("01"); 
        meta.setBeneficiaryIdExpiry("2029-02-16");
        meta.setBeneficiaryDob("2007-12-31");
        meta.setSenderGender("m");
        meta.setDebitCurrencyAmount("12.39");
        
        
        
        // Add the meta object to a list
        List<Meta> metaList = new ArrayList<>();
        metaList.add(meta);

        // Set the meta list to the main object
        p.setMeta(metaList);
		
		
		String res = given().log().all().header("Content-Type","application/json").header("Authorization", "FLWSECK-dc63611d01f0d12a05a67473ac618460-195afc6eddcvt-X")
		.body(p)
		.when().post("/v3/transfers")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		
		System.out.println(res);
		
		//To get the transfer ref from the response
		JsonPath jsonpath = new JsonPath(res);
		String transRef = jsonpath.getString("data.reference");
		System.out.println(transRef);
		
		//To fetch actual transfers
		String res2 = given().log().all().header("Content-Type","application/json").header("Authorization", "FLWSECK-dc63611d01f0d12a05a67473ac618460-195afc6eddcvt-X")
				.queryParam("reference", transRef).queryParam("include_debit_currency_amount", "true").queryParam("include_rate", "true")
				.when().log().all()
				.get("/v3/transfers")
				.then().extract().response().asString();
		
		System.out.println(res2);
		
		
		
		

	}

}
