package com.eca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eca.model.Ecommerce;
import com.eca.repository.EcommerceRepo;

@Service
public class EcomImpl implements EcommerceService {

	@Autowired
	private EcommerceRepo repo;

	@Override
	public Ecommerce createProduct(Ecommerce product) {
		Ecommerce saveProduct = null;
		try {

			System.out.println("Product has been added successfully" + product.getName());
			saveProduct = repo.save(product);
		} catch (Exception e) {
			System.out.println("Sorry..Something went wrong not able to add your product" + product.getName());

		}
		return saveProduct;
	}

	@Override
	public Ecommerce readProduct(int productId) {

		return repo.findById(productId).orElse(new Ecommerce());
	}

	@Override
	public Ecommerce updateProduct(Ecommerce ecom) {
		Ecommerce updateproduct = new Ecommerce();
		updateproduct.setProductId(ecom.getProductId());
		updateproduct.setName(ecom.getName());
		updateproduct.setDescription(ecom.getDescription());
		updateproduct.setPrice(ecom.getPrice());
		updateproduct.setQuantityAvailable(ecom.getQuantityAvailable());
		return repo.save(updateproduct);
	}

	@Override
	public String deleteProduct(int productId) {
		repo.deleteById(productId);
		return productId + "Deleted";
	}

	@Override
	public List<Ecommerce> readAllDetails() {
		return repo.findAll();
	}

	@Override
	public Ecommerce applyDiscountOrTax(int productId, Double discountRate, Double taxRate) {
		Optional<Ecommerce> ecomOpt = repo.findById(productId);
		Ecommerce ecom = ecomOpt.orElseThrow();

		if (discountRate != null) {
			double discountAmount = ecom.getPrice() * discountRate / 100;
			ecom.setPrice(ecom.getPrice() - discountAmount);
			ecom.setDiscountRate(discountRate);
		} else if (taxRate != null) {
			double taxAmount = ecom.getPrice() * taxRate / 100;
			ecom.setPrice(ecom.getPrice() + taxAmount);
			ecom.setTaxRate(taxRate);
		}

		Ecommerce updatedProduct = repo.save(ecom);
		return updatedProduct;
	}
}