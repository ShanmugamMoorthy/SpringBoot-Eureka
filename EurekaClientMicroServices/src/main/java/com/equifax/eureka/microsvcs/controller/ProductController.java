/**
 * 
 */
package com.equifax.eureka.microsvcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equifax.eureka.microsvcs.model.Product;
import com.equifax.eureka.microsvcs.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "eureka-micro-services", description = "Operations pertaining to Products", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, path = "/api/v1/products", produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "Retrieve all the products ", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved products list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the products"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The products you were trying to reach is not found") })
	public ResponseEntity<List<Product>> getAllItems() {

		List<Product> productList = productService.getAllItems();
		if (productList == null || productList.isEmpty() ) {
			return new ResponseEntity<>(productList, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/api/v1/product/{id}", produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "Retrieve product by product id ", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved product detail"),
			@ApiResponse(code = 401, message = "You are not authorized to view the products"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The products you were trying to reach is not found") })
	public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

}
