package com.springBoot.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.restapi.model.Product;
import com.springBoot.restapi.service.InventoryService;

@RequestMapping("api/v1/product")
@RestController
public class InventoryController {

	private final InventoryService inventoryService;

	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@PostMapping
	public void addProduct(@RequestBody Product product) {
		inventoryService.addProduct(product);
	}
	
	@DeleteMapping(path ="/{id}")
	public int deleteProductByID(@PathVariable("id") int productID) {
		return inventoryService.deleteProductByID(productID);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		System.out.println("Hello World");
		return inventoryService.getAllProducts();
	}

	@GetMapping(path ="/{id}")
	public Optional<Product> getProductDetails(@PathVariable("id") int id) {
		return 	inventoryService.getProductDetails(id);
	}
}
