package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.todo.status;
import com.example.todo.model.User;
import com.example.todo.repository.UserRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo userrepo;

	@PostMapping("/user/register")
	public status register(@RequestBody User newuser) {
		List<User> users = userrepo.findAll();
		System.out.println("New User: " + newuser.toString());

		for (User user : users) {
			System.out.println("Registered user: " + newuser.toString());

			if (user.equals(newuser)) {
				System.out.println("User already exist!!");
				return status.USER_ALREADY_EXISTS;
			}

		}

		userrepo.save(newuser);
		return status.SUCCESS;
	}

	@PutMapping("/user/login")
	public status loginUser(@RequestBody User user) {
		List<User> users = userrepo.findAll();

		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(true);
				userrepo.save(user);
				return status.SUCCESS;
			}
		}
		return status.FAILURE;
	}

	@PutMapping("/user/logout")
	public status logUserOut(@RequestBody User user) {
		List<User> users = userrepo.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(false);
				userrepo.save(user);
				return status.SUCCESS;
			}
		}
		return status.FAILURE;
	}
}
