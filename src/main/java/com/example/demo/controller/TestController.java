package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TestResponse;
import com.example.demo.service.TestService;

/**
 * 
 * @author Deepak
 * 
 * This is a controller class to expose API's required for the technical demo
 *
 */

@RestController
@RequestMapping("/myobdemo/v1")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	  /**
	   * Returns response Hello World.
	   *
	   * @return a string
	   */
	  @RequestMapping(value="/hello",method=RequestMethod.GET)
	  public TestResponse getHello() {
	    return testService.getHello();
	  }
	  
	  /**
	   * Retrieves the health check details of the application.
	   *
	   * @return Health status
	   */
	  @RequestMapping(value="/health",method=RequestMethod.GET)
	  public Health getHealth() {
		  return testService.getHealth();
	  }
	  

}
