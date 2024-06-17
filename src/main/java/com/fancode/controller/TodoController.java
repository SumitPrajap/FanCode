package com.fancode.controller;

import java.util.List;

import com.fancode.mapper.Todo;
import com.fancode.mapper.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TodoController {

	private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
	ObjectMapper objectMapper = new ObjectMapper();

	// Method to fetch all todos
	public List<Todo> getAllTodos() {
		List<Todo> todoList = null;
		Response response = RestAssured.get(BASE_URL + "/todos");
		String res = response.getBody().asPrettyString();
		try {
			todoList = objectMapper.readValue(res, new TypeReference<List<Todo>>() {
			});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return todoList;
	}

	// Method to fetch todos for a specific user ID
	public List<Todo> getTodosByUserId(int userId) {
		List<Todo> todoList = null;
		Response response = RestAssured.get(BASE_URL + "/todos?userId=" + userId);
		String res = response.getBody().asPrettyString();
		try {
			todoList = objectMapper.readValue(res, new TypeReference<List<Todo>>() {
			});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return todoList;
	}

	// Method to fetch a single todo by ID
	public Todo getTodoById(int todoId) {
		Todo todo = null;
		Response response = RestAssured.get(BASE_URL + "/todos/" + todoId);
		String res = response.getBody().asPrettyString();
		try {
			todo = objectMapper.readValue(res, new TypeReference<Todo>() {
			});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return todo;
	}

}
