package com.fancode.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.testng.Assert;

import com.fancode.mapper.Users;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserController {

	ObjectMapper objectMapper = new ObjectMapper();
	private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

	// Method to fetch all users
	public List<Users> getAllUsers() {
		List<Users> userList = null;
		Response response = RestAssured.get(BASE_URL + "/users");
		String res = response.getBody().asPrettyString();
		try {
			userList = objectMapper.readValue(res, new TypeReference<List<Users>>() {
			});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return userList;
	}

	// Method to fetch a single user by ID
	public Users getUserById(int userId) {
		Users user = null;
		Response response = RestAssured.get(BASE_URL + "/users/" + userId);
		String res = response.getBody().asPrettyString();
		try {
			user = objectMapper.readValue(res, new TypeReference<Users>() {
			});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return user;
	}

}
