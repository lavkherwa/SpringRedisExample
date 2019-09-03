package com.example.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.redis.model.User;

@Configuration
@EnableCaching
public class Config {

	@Bean
	public JedisConnectionFactory JedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, User> redisTemplate() {
		final RedisTemplate<String, User> template = new RedisTemplate<>();
		template.setConnectionFactory(JedisConnectionFactory());
		return template;
	}

}
