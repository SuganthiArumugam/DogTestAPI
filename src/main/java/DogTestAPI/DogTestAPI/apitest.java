package DogTestAPI.DogTestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.session.SessionFilter;
import io.restassured.specification.RequestSpecification;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.imageio.ImageIO;

import static io.restassured.RestAssured.*;
import static io.restassured.config.SessionConfig.sessionConfig;


import org.testng.Assert.*;


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