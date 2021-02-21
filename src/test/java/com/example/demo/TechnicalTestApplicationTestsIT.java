package com.example.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class TechnicalTestApplicationTestsIT {

	@Autowired
    private MockMvc mockMvc;
	
	String baseUrl = "http://localhost:8080/myobdemo";
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testHelloIT() {
		try {
			MvcResult result = (mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/v1/hello"))).andReturn();
			String response = result.getResponse().getContentAsString();
			assertNotNull(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
