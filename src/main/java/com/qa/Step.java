package com.qa;

import org.json.simple.JSONObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unchecked")
public class Step {
	
	RequestSpecification request = RestAssured.given();
	
	@Given("^that the items list has the status code (\\d+)$")
	public void that_the_items_list_has_the_status_code(int arg1)
	{
		Response GetPost = request.get("http://localhost:8090/example/v1/hotels/");
		GetPost.then().statusCode(arg1);
		GetPost.prettyPrint();
		System.out.println("GIVEN__________");
	}

//	@SuppressWarnings("unchecked")
	@When("^a new hotel entry is posted$")
	public void a_new_hotel_entry_is_posted()
//	throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//	}
	
	{
		request.header("Content-Type", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "New CityTM");
		requestParams.put("description", "Airbnb");
		requestParams.put("name", "Jason");
		requestParams.put("rating", "7");
		request.body(requestParams);
		Response GetPost2 = request.post("http://localhost:8090/example/v1/hotels/");
		GetPost2.then().statusCode(201);
		GetPost2.prettyPrint();
		System.out.println("WHEN1__________");
	}

//	@SuppressWarnings("unchecked")
	@When("^its information is updated$")
	public void its_information_is_updated()
//			throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}

	{
		request.header("Content-Type", "application/json");
		JSONObject requestParams = new JSONObject();
		@SuppressWarnings("unused")
		Response GPC = request.post("http://localhost:8090/example/v1/hotels/17");
		requestParams.put("id", "17");
		requestParams.put("city", "Even newer city");
		requestParams.put("description", "Nicer crib");
		requestParams.put("name", "Baller");
		requestParams.put("rating", "10");
		System.out.println("HMMM__________");
		request.body(requestParams);
		Response GPC1 = request.put("http://localhost:8090/example/v1/hotels/17");
		System.out.println("HMMM__________");
		GPC1.prettyPrint();
//		GPC1.then().statusCode(201);
		System.out.println("WHEN2__________");
	}

	@When("^then this entry is deleted$")
	public void then_this_entry_is_deleted()
	{
//		String iDel = "1";
		Response response = request.delete("http://localhost:8090/example/v1/hotels/17");
		response.then().statusCode(204);
		response.prettyPrint();
		System.out.println("WHEN3__________");
	}

	@Then("^the error code (\\d+) is returned$")
	public void the_error_code_is_returned(int arg1) throws Throwable
	{
		Response GetOnePost = request.get("http://localhost:8090/example/v1/hotels/17");
		GetOnePost.then().statusCode(404);
		GetOnePost.prettyPrint();
		System.out.println("THEN__________");
	}
}
