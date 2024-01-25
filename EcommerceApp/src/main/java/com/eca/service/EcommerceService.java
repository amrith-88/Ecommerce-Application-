package com.eca.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.eca.model.Ecommerce;
 @Service
public interface EcommerceService {
	 
    Ecommerce createProduct(Ecommerce ecom);
    
    Ecommerce updateProduct(Ecommerce ecom);
    
    String deleteProduct(int productId);
    
    Ecommerce readProduct(int productId);
    
    List<Ecommerce> readAllDetails();
    
    Ecommerce applyDiscountOrTax(int productId, Double discountRate, Double taxRate);
}