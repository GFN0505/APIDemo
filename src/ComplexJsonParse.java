import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		
		//Print number of courses
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print Title of first course
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//Print all course titles and their respective prices
		for(int i=0; i<count; i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			int coursePrices = js.get("courses["+i+"].price");
			System.out.println(courseTitles);
			System.out.println(coursePrices);
			
		}
		
		//Get copies if Title is RPA
		for(int i=0; i<count; i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int RPAcopies = js.get("courses["+i+"].copies");
				System.out.println(RPAcopies);
				break;
				
			}
				
		}
		

		
		
	}

}
