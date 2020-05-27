package com.springBoot.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	private final int product_id;
	private final String product_name;
		
	public Product(@JsonProperty("id") int product_id, 
			@JsonProperty("name") String product_name) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
	}
	
	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}	
}