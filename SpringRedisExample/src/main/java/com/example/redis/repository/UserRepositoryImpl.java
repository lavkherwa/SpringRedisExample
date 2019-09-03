package com.example.redis.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redis.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final String CONTAINER_KEY = "USER";

	private final RedisTemplate<String, User> redisTemplate;
	private final HashOperations<String, String, User> hashOperations;

	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = this.redisTemplate.opsForHash();

	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries(CONTAINER_KEY);
	}

	@Override
	public User findById(String id) {
		return hashOperations.get(CONTAINER_KEY, id);
	}

	@Override
	public void save(User user) {
		hashOperations.put(CONTAINER_KEY, user.getId(), user);
	}

	@Override
	public void update(User user) {
		hashOperations.put(CONTAINER_KEY, user.getId(), user);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(CONTAINER_KEY, id);
	}

}
