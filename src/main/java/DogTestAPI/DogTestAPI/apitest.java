package DogTestAPI.DogTestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;


public class apitest {

	@Test
public void ListAllBreeds() throws IOException
{   
	RestAssured.baseURI = "https://dog.ceo/";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET, "/api/breeds/list/all");
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode,200);
	String responseBody = response.getBody().asString();
	System.out.println("AllBreeds:  " + responseBody);

}
	@Test
	public void ListAllSubBreeds() throws IOException
	{   
		RestAssured.baseURI = "https://dog.ceo/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "api/breed/hound/list");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		String responseBody = response.getBody().asString();
		System.out.println("All SubBreeds:  " + responseBody);
	}
	
	@Test
	public void ListBreedImages() throws IOException
	{   
		RestAssured.baseURI = "https://dog.ceo/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "api/breed/hound/afghan/images");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		String responseBody = response.getBody().asString();
		System.out.println("Breed Images  " + responseBody);

	}
		
	@Test
	public void RandomBreedImage() throws IOException
	{   
		RestAssured.baseURI = "https://dog.ceo/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "api/breed/african/images/random");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		String img = response.jsonPath().get("message");
		Assert.assertTrue(img.contains(".jpg"));
		String responseBody = response.getBody().asString();
		System.out.println("Random Breed Image  " + responseBody);

	}
	
}