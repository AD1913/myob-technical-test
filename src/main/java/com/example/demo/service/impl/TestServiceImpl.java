package com.example.demo.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ResponseData;
import com.example.demo.domain.TestResponse;
import com.example.demo.service.TestService;

/**
 * 
 * Service class to implement the methods required for technical demo
 * 
 * @author Deepak
 *
 */

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestResponse testResponse;
	
	@Autowired
	ResponseData responseData;
	
	/**
	 * getHello method to return a sample response with a message Hello World
	 * 
	 */
	@Override
	public TestResponse getHello() {
		responseData.setResponse("Hello World");
		
		testResponse.setStatus("Success");
		testResponse.setData(responseData);
		testResponse.setMessage(null);
		return testResponse;
	}
	
	/**
	 * getHealth method returns the health details of the application.
	 * It verifies the health check url and updates few more details before 
	 * returning the response back.
	 */
	@Override
	public Health getHealth() {
		try {
			URL url =
				new URL("http://localhost:8080/myobdemo/health");
			HttpURLConnection conn =
				(HttpURLConnection) url.openConnection();
			
			int statusCode = conn.getResponseCode();
			if (statusCode >= 200 && statusCode < 300) {
				return Health.up().withDetail("HTTP Status Code", statusCode).build();
			} else {
				return Health.down()
					.withDetail("HTTP Status Code", statusCode)
					.build();
			}
		} catch (IOException e) {
			return Health.down(e).build();
		}
	}
	
}
