/**
 * @author Vamsi Ravi
 */
package com.api.automation.zeus.testscripts.samples;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Vamsi Ravi
 *
 */
public class ValidateContentType {

	@Test
	public void validateResponseContentType(){	
		RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1").then().extract().contentType().equals(ContentType.APPLICATION_JSON);
	}
	
	@Test
	public void validateResponseContentTypeFromRawResponse(){
		Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1").thenReturn();
		
		if(response.getHeader("Content-Type").equals(ContentType.APPLICATION_JSON)){
			Assert.assertTrue(true);
		}else{
			Assert.fail();
		}
		
	}

	@Test
	public void expectReponseHeaderContentType(){
		RestAssured.given().expect().header("Content-Type", equalTo(ContentType.APPLICATION_JSON)).when().get();
	}
	
	@Test
	public void expectResponseContentTypeWithHamcrestMatcher(){
		RestAssured.given().expect().contentType(is("application/json;charset=utf-8")).when().get();
		
	}
	
}
