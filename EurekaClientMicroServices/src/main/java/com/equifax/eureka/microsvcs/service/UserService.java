package com.equifax.eureka.microsvcs.service;

import java.util.List;
import java.util.Map;

import com.equifax.eureka.microsvcs.model.User;

public interface UserService {

	List<User> searchUser(String searchKey);

	Map<String,User> getAllUsers();

}
