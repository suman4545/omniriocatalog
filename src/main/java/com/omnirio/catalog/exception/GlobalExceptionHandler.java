package com.omnirio.catalog.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoDeatailsFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoRecordFoundException(NoDeatailsFoundException ex) 
	{ 
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);	
	}
	
	
	@ExceptionHandler(DataPersisException.class)
	public ResponseEntity<ErrorResponse> handleDataPersisException(DataPersisException ex) 
	{ 
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleRequiredDataNotFoundException(ConstraintViolationException ex) 
	{ 
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	

}
