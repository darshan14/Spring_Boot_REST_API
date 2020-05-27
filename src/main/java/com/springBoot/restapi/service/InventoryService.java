package com.springBoot.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springBoot.restapi.dao.InventoryDataAccessService;
import com.springBoot.restapi.model.Product;

@Service
public class InventoryService {
	
	private final InventoryDataAccessService inventoryDataAccessService;

    @Autowired
    public InventoryService(@Qualifier("FakeDAO") InventoryDataAccessService inventoryDataAccessService) {
        this.inventoryDataAccessService = inventoryDataAccessService;
    }

    public int addProduct(Product product) {
    	return inventoryDataAccessService.addProduct(product);
    }
    
    public int deleteProductByID(int productID) {
    	return inventoryDataAccessService.deleteProductByID(productID);
    }
    
    public Optional<Product> getProductDetails(int id) {	
		return inventoryDataAccessService.getProductDetails(id);
	}
    
    public List<Product> getAllProducts() {
    	return inventoryDataAccessService.selectAllProducts();
    }	
}
