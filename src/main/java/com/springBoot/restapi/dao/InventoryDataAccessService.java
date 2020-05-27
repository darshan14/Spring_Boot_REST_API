package com.springBoot.restapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.springBoot.restapi.model.Product;

@Repository("FakeDAO")
public class InventoryDataAccessService implements InventoryDAO{
	
	private static List<Product> productList = new ArrayList<Product>();
	
	@Override
	public int addProduct(Product product) {
		Random r = new Random();
		productList.add(new Product(r.nextInt(), product.getProduct_name()));
		return 1;
	}

	@Override
	public int deleteProductByID(int productID) {
		Optional<Product> product = getProductDetails(productID);
		if(!product.isPresent())
			return 0;
		productList.remove(product.get());
		return 1;
	}

	@Override
	public Optional<Product> getProductDetails(int id) {	
		return productList.stream().filter(product -> product.getProduct_id() == id).findFirst();
	}

	@Override
	public List<Product> selectAllProducts() {
		return productList;
	}
}
