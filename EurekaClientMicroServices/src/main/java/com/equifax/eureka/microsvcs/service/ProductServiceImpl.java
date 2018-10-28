package com.equifax.eureka.microsvcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.eureka.microsvcs.model.Product;
import com.equifax.eureka.microsvcs.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prodRepository;

	@Override
	public List<Product> getAllItems() {
		return prodRepository.getAllItems();
	}

	@Override
	public Product getProductById(String productId) {
		return prodRepository.getProductById(productId);
	}

}
