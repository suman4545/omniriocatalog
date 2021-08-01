package com.omnirio.catalog.exception;

public class NoDeatailsFoundException extends RuntimeException{
	
	 public NoDeatailsFoundException() {
	        super();
	    }
	    public NoDeatailsFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public NoDeatailsFoundException(String message) {
	        super(message);
	    }
	    public NoDeatailsFoundException(Throwable cause) {
	        super(cause);
	    }

}
