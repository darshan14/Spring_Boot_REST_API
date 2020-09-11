package com.springBoot.restapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.springBoot.restapi.model.Product;

public class TestAPIController extends SpringBootRestApiApplication{
	
	@LocalServerPort
	private int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGetProductListSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/api/v1/product/";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	    //assertEquals(true, result.getBody().contains("productList"));
	}

	/*
	 * @Test public void testAddProduct() throws URISyntaxException, JSONException {
	 * RestTemplate restTemplate = new RestTemplate(); //final String baseUrl =
	 * "http://localhost:"+randomServerPort+"/api/v1/product/"; final String baseUrl
	 * = "http://localhost:8080/api/v1/product/"; URI uri = new URI(baseUrl);
	 * 
	 * JSONObject productJsonObject = new JSONObject(); productJsonObject.put("id",
	 * 1001); productJsonObject.put("name", "John");
	 * 
	 * //Product product = new Product(101, "Adam");
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * 
	 * HttpEntity<String> request = new
	 * HttpEntity<String>(productJsonObject.toString(), headers);
	 * 
	 * try { ResponseEntity<String> responseEntityStr =
	 * restTemplate.postForEntity(uri, request, String.class);
	 * assertNotNull(responseEntityStr.getBody()); fail(); }
	 * catch(HttpClientErrorException ex) { //Verify bad request and missing header
	 * assertEquals(400, ex.getRawStatusCode()); assertEquals(true,
	 * ex.getResponseBodyAsString().contains("Missing request header")); } }
	 */
	
}
