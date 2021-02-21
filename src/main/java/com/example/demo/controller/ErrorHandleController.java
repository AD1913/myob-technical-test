package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 
 * @author DeepakSindhu
 *
 * Error Controller to handle the exception scenarios
 */

@RestControllerAdvice
public class ErrorHandleController {

	/**
	 * 
	 * Method to handle HTTP NOT Found exceptions.
	 * Handles the exception and returns a response with appropriate status code and message
	 * 
	 * @param exception
	 * @param request
	 * @return HashMap<String, String>
	 */
	
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", e.getLocalizedMessage());
        response.put("statusCode", HttpStatus.NOT_FOUND.toString());
        response.put("status", "fail");
        return response;
    }
}