package com.eca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eca.model.Ecommerce;
import com.eca.service.EcommerceService;

@RestController
public class EcomController {

	@Autowired
	private EcommerceService service;

	@PostMapping("/addDetails")
	public Ecommerce addDetails(@RequestBody Ecommerce ecom) {
		return service.createProduct(ecom);

	}

	@PutMapping("/editEcommerce")
	public Ecommerce updateDetails(@RequestBody Ecommerce ecom) {
		return service.updateProduct(ecom);
	}

	@DeleteMapping("/deleteDetails/{productId}")
	public String deleteDetails(@PathVariable int productId) {
		return service.deleteProduct(productId);

	}

	@GetMapping("/getAllDetails")
	public List<Ecommerce> getallDetails() {
		return service.readAllDetails();

	}

	@PutMapping("/products/{id}/modifyPrice")
	public ResponseEntity<Ecommerce> applyDiscountOrTax(@PathVariable(value = "id") int productId,
			@RequestParam(required = false) Double discountRate, @RequestParam(required = false) Double taxRate) {
		Ecommerce updatedProduct = service.applyDiscountOrTax(productId, discountRate, taxRate);
		return ResponseEntity.ok(updatedProduct);
	}
}
