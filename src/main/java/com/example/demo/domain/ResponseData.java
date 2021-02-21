package com.example.demo.domain;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Deepak
 * 
 * ResponseData class holds the actual attributes required for the response.
 * This application responds only with a single string message.
 *
 */
@Component
public class ResponseData {

	private String response;

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
