package com.example.redis.config;

import java.time.Duration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.redis.model.User;

@Configuration
@EnableCaching
public class Config {

	/*- BELOW CODE IS DEPRECATED FOR SPRING 2.X
		@Bean
		public JedisConnectionFactory JedisConnectionFactory() {
			JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
			jedisConFactory.setHostName("localhost");
			jedisConFactory.setPort(6379);
			return jedisConFactory;
		}
	*/

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		/*
		 * By default spring configure it for local but here is how you can provide
		 * custom connection properties
		 */
		redisStandaloneConfiguration.setHostName("localhost");
		redisStandaloneConfiguration.setPort(6379);
//		redisStandaloneConfiguration.setDatabase(0);
//		redisStandaloneConfiguration.setPassword(RedisPassword.of("password"));

		JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
		jedisClientConfiguration.connectTimeout(Duration.ofSeconds(60));// 60s connection timeout

		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration,
				jedisClientConfiguration.build());

		return jedisConFactory;
	}

	@Bean
	public RedisTemplate<String, User> redisTemplate() {
		final RedisTemplate<String, User> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
