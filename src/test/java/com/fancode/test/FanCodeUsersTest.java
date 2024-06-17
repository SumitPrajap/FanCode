package com.fancode.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fancode.controller.TodoController;
import com.fancode.controller.UserController;
import com.fancode.mapper.Todo;
import com.fancode.mapper.Users;

public class FanCodeUsersTest {

	UserController userControler = new UserController();
	TodoController todos = new TodoController();
	double minLat = -40.0;
	double maxLat = 5.0;
	double minLong = 5.0;
	double maxLong = 100.0;

	@Test
	public void testFanCodeUsersCompletedTasksPercentage() {
		// Fetch all users
		List<Users> usresList = userControler.getAllUsers();
		for (Users user : usresList) {

			if (isFanCodeCity(user)) {
				// Fetch todos for this user
				List<Todo> todosList = todos.getTodosByUserId(user.getId());

				// Calculate completed todos percentage
				long totalTodos = todosList.size();
				long completedTodos = todosList.stream().filter(Todo::isCompleted).count();
				double completionPercentage = (completedTodos * 100.0) / totalTodos;		
				Assert.assertTrue(completionPercentage > 50.0, "User " + user.getName() + " from FanCode city has more than 50% todos completed.");
			}

		}

	}

	private boolean isFanCodeCity(Users singleUser) {
		double lat = Double.parseDouble(singleUser.getAddress().getGeo().getLat());
		double lng = Double.parseDouble(singleUser.getAddress().getGeo().getLng());
		return lat >= -40.0 && lat <= 5.0 && lng >= 5.0 && lng <= 100.0;
	}

}
