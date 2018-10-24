package com.qa;

import org.json.simple.JSONObject;
import org.junit.Test;

// import com.qa.restassuredtest.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unused")
public class JUnit
{
	
	RequestSpecification request = RestAssured.given();
	
//	public static void main(String[] args) {
//		getMethods();
//		postMethod();
//		deleteMethod();
//	}
	
	@Test
	public void getMethods()
	{
	Response GetPost = request.get(Constants.GetPost);
	GetPost.then().statusCode(200);
	GetPost.prettyPrint();
	}
	
//	@Test
//	public void getOneMethod()
//	{
//		String id = "20";
//		Response response = request.get(Constants.GetPost + id);
//		response.then().statusCode(200);
//		response.prettyPrint();
//	}
	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void postMethod()
//	{
//	request.header("Content-Type", "application/json");
//	JSONObject requestParams = new JSONObject();
//	requestParams.put("city", "New");
//	requestParams.put("description", "bedsit for six");
//	requestParams.put("name", "New");
//	requestParams.put("rating", "3");
//	
//	request.body(requestParams);
//	
//	Response GetPost2 = request.post(Constants.GetPost);
//	GetPost2.then().statusCode(201);
//	GetPost2.prettyPrint();
//	}
	
//	@Test
//	public void deleteMethod()
//	{
//	Response Delete3 = request.delete(Constants.Delete);
//	Delete3.then().statusCode(204);
//	Delete3.prettyPrint();
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void putMethod()
//	{
//	request.header("Content-Type", "application/json");
//	JSONObject requestParams = new JSONObject();
//	Response GetPut = request.post(Constants.GetPut);
//	requestParams.replace("city", "Boston");
//	requestParams.replace("description", "hoston");
//	requestParams.replace("name", "Roston");
//	requestParams.replace("rating", "5");
//	request.body(requestParams);
//	Response GetPost4 = request.post(Constants.GetPost);
//	GetPost4.then().statusCode(201);
//	GetPost4.prettyPrint();
//	}
}