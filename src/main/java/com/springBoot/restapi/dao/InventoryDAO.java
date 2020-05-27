package com.springBoot.restapi.dao;

import java.util.List;
import java.util.Optional;

import com.springBoot.restapi.model.Product;

public interface InventoryDAO {
	
	int addProduct(Product product);
	
	int deleteProductByID(int productID);
	
	Optional<Product> getProductDetails(int id);
	
	List<Product> selectAllProducts();
	
}
