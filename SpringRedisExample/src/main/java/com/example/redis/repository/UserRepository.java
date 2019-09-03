package com.example.redis.repository;

import java.util.Map;

import com.example.redis.model.User;

public interface UserRepository {

	Map<String, User> findAll();

	User findById(String id);

	void save(User user);

	void update(User user);

	void delete(String id);

}
