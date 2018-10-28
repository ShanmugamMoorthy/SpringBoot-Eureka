/**
 * 
 */
package com.equifax.eureka.microsvcs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equifax.eureka.microsvcs.model.User;
import com.equifax.eureka.microsvcs.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "eureka-micro-services", description = "Operations pertaining to Users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private UserService userService ;

	@RequestMapping(method = RequestMethod.GET, path = "/api/v1/user/search/{searchKey}", consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "Search User for the Micro Services ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved User Details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the users"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The user you were trying to reach is not found") })
	public ResponseEntity<User> searchUser(@PathVariable("searchKey") String searchKey) {

		User user = new User();
		try {
			List<User> myUser = userService.searchUser(searchKey);
			if (!CollectionUtils.isEmpty(myUser)) {
				user = myUser.get(0);
			}
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/v1/users", consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "Retrive All Users for the Micro Services ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved All Users"),
			@ApiResponse(code = 401, message = "You are not authorized to view the users"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The users you were trying to reach is not found") })
	public ResponseEntity<Map<String, User>> getAllUsers() {

		Map<String, User> myUser = userService.getAllUsers();
		return new ResponseEntity<>(myUser, HttpStatus.OK);
	}

}
