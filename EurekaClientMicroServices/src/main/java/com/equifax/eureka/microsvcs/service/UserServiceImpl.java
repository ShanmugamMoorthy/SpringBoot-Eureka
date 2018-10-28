package com.equifax.eureka.microsvcs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.eureka.microsvcs.model.User;
import com.equifax.eureka.microsvcs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository ;

	@Override
	public List<User> searchUser(String searchKey) {
		return userRepository.searchUser(searchKey);
	}


	@Override
	public Map<String,User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	
}
