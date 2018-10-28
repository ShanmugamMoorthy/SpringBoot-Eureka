/**
 * 
 */
package com.equifax.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class EurekaClientController {

	private final static String HTTP = "http://";
	private final static String COLON = ":";
	private final static String FWD_SLASH = "/";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EurekaClient eurekaClientForMS;

	@GetMapping("/getAllItems")
	public ResponseEntity getAllProductItems() {

		Application application = eurekaClientForMS.getApplication("eureka-microservices");
		InstanceInfo instance = application.getInstances().get(0);
		StringBuilder restUrl = new StringBuilder(HTTP);
		restUrl.append(instance.getIPAddr()).append(COLON);
		restUrl.append(instance.getPort()).append(FWD_SLASH);
		restUrl.append("api/v1/products");
		ResponseEntity response = restTemplate.getForObject(restUrl.toString(), ResponseEntity.class);
		return response;
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity getProductById(@PathVariable("id") String prodId) {

		Application application = eurekaClientForMS.getApplication("eureka-microservices");
		InstanceInfo instance = application.getInstances().get(0);
		StringBuilder restUrl = new StringBuilder(HTTP);
		restUrl.append(instance.getIPAddr()).append(COLON);
		restUrl.append(instance.getPort()).append(FWD_SLASH);
		restUrl.append("api/v1/product/" + prodId);
		ResponseEntity response = restTemplate.getForObject(restUrl.toString(), ResponseEntity.class);
		return response;
	}

	@GetMapping("/searchUser/{searchKey}")
	public ResponseEntity searchUser(@PathVariable("searchKey") String searchKey) {

		Application application = eurekaClientForMS.getApplication("eureka-microservices");
		InstanceInfo instance = application.getInstances().get(0);
		StringBuilder restUrl = new StringBuilder(HTTP);
		restUrl.append(instance.getIPAddr()).append(COLON);
		restUrl.append(instance.getPort()).append(FWD_SLASH);
		restUrl.append("api/v1/user/search/" + searchKey);
		ResponseEntity response = restTemplate.getForObject(restUrl.toString(), ResponseEntity.class);
		return response;
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity getAllUsers() {

		Application application = eurekaClientForMS.getApplication("eureka-microservices");
		InstanceInfo instance = application.getInstances().get(0);
		StringBuilder restUrl = new StringBuilder(HTTP);
		restUrl.append(instance.getIPAddr()).append(COLON);
		restUrl.append(instance.getPort()).append(FWD_SLASH);
		restUrl.append("api/v1/users");
		ResponseEntity response = restTemplate.getForObject(restUrl.toString(), ResponseEntity.class);
		return response;
	}

}