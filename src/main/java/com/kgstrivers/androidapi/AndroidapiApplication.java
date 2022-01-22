package com.kgstrivers.androidapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AndroidapiApplication {


	@RequestMapping
	public String hello()
	{
		return "Hello";
	}


	public static void main(String[] args) {
		SpringApplication.run(AndroidapiApplication.class, args);
	}

	@Bean
	LettuceConnectionFactory lettuceConnectionFactory()
	{
		return new LettuceConnectionFactory();
	}


	@Bean
	RedisTemplate redisTemplate()
	{


		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory());
		return redisTemplate;
	}

}
