package com.example.redis.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.model.User;
import com.example.redis.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.//
				findAll()//
				.values()//
				.stream()//
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		return userRepository.findById(id);
	}

	@PostMapping
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) {
		userRepository.update(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		userRepository.delete(id);
	}

}
