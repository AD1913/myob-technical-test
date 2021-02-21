package com.example.demo;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.TestResponse;
import com.example.demo.service.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TechnicalTestApplicationTests {

	@Autowired
	TestService testService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
    public void testHello() throws URISyntaxException 
    {
		TestResponse testResponse = testService.getHello();
	     
	    //Verify request succeed
	    Assert.assertEquals(true, testResponse.getData().getResponse().contains("Hello World"));
    }  

}
