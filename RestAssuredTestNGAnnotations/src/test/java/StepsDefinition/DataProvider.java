package StepsDefinition;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DataProvider {

	Response response;
	
	@org.testng.annotations.DataProvider(name="Date")
	public Object[][] provider(){
		Object[][] data =new Object[2][3];
		
		data[0][0]="2000";
		data[0][1]="12";
		data[0][2]="06";
		
		data[1][0]="2021";
		data[1][1]="06";
		data[1][2]="30";
		return data;
	}

	
	@Test
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange() {
	    RestAssured.baseURI="https://api.ratesapi.io";
	}

	@Test(dataProvider="Date")
	@When("posted with future date value")
	public void posted_with_future_date_value(String year, String mon, String day) {
		response=RestAssured.get("/api/"+year+"-"+mon+"-"+day);
	}

	@Test
	@Then("validate positive response code")
	public void validate_positive_response_code() {
		int code=response.getStatusCode();
		Assert.assertEquals(code,200);
		System.out.println(code);

		String txt=response.getStatusLine();
		Assert.assertTrue(txt.contains("OK"));
		System.out.println(txt);
		
	}
}
