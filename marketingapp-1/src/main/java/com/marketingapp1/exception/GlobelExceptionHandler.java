package com.marketingapp1.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.marketingapp1.dto.ErrorDetails;

@ControllerAdvice
public class GlobelExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class)  
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
			ResourceNotFoundException exception,
			WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(), 
			webRequest.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(Exception.class)//if we use exception then meant it handle all type of exception.
    public ResponseEntity<ErrorDetails> globalException(
    		Exception e,
        	WebRequest webRequest
    		){
    	 ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(false));
    	 return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
