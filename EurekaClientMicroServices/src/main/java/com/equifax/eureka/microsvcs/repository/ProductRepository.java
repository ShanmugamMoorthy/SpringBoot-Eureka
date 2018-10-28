package com.equifax.eureka.microsvcs.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.equifax.eureka.microsvcs.model.Product;
import com.equifax.eureka.microsvcs.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProductRepository {

	private final static String PRODUCT_LIST_JSON = "/ProductList.json";

	/**
	 * 
	 * @return
	 */
	public List<Product> getAllItems() {

		List<Product> prodList = new ArrayList<Product>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			prodList = mapper.readValue(JsonUtils.readJsonFile(PRODUCT_LIST_JSON), new TypeReference<List<Product>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prodList;

	}

	/**
	 * 
	 * @param productId
	 * @return
	 */
	public Product getProductById(String productId) {

		List<Product> prodList = new ArrayList<Product>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			prodList = mapper.readValue(JsonUtils.readJsonFile(PRODUCT_LIST_JSON), new TypeReference<List<Product>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Product prod : prodList) {
			if (productId.equalsIgnoreCase(prod.getProdId())) {
				return prod;
			}
		}
		return null;

	}

}
