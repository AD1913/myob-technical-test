package com.example.demo.service;

import org.springframework.boot.actuate.health.Health;

import com.example.demo.domain.TestResponse;

public interface TestService {

	public TestResponse getHello();
	public Health getHealth();
	
}
