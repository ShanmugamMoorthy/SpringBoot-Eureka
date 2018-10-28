/**
 * 
 */
package com.equifax.eureka.microsvcs.service;

import java.util.List;

import com.equifax.eureka.microsvcs.model.Product;

public interface ProductService {
	
	List<Product> getAllItems ();
	
	Product getProductById(String productId);

}
