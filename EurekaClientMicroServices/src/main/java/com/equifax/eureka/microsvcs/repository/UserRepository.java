package com.equifax.eureka.microsvcs.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.equifax.eureka.microsvcs.model.User;
import com.equifax.eureka.microsvcs.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class UserRepository {

	private final static String USER_JSON = "/UserList.json";

	public List<User> searchUser(String searchKey) {

		List<User> userList = new ArrayList<User>();
		Map<String, User> mapData = new HashMap<String, User>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapData = mapper.readValue(JsonUtils.readJsonFile(USER_JSON), new TypeReference<Map<String, User>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null == mapData.get(searchKey)) {
			return userList;
		}
		userList.add(mapData.get(searchKey));
		return userList;

	}

	public Map<String, User> getAllUsers() {

		Map<String, User> mapData = new HashMap<String, User>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapData = mapper.readValue(JsonUtils.readJsonFile(USER_JSON), new TypeReference<Map<String, User>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapData;
	}
	
}
