package com.example.demo.domain;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Deepak
 * 
 * Response class for all the requests either success or failure.
 * ResponseData object present in this response class holds the actual response.
 *
 */
@Component
public class TestResponse {

	private String status;
	private ResponseData data;
	private String message;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the data
	 */
	public ResponseData getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(ResponseData data) {
		this.data = data;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
