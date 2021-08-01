package com.omnirio.catalog.exception;

public class RequiredDataNotFoundException extends RuntimeException{
	
	 public RequiredDataNotFoundException() {
	        super();
	    }
	    public RequiredDataNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public RequiredDataNotFoundException(String message) {
	        super(message);
	    }
	    public RequiredDataNotFoundException(Throwable cause) {
	        super(cause);
	    }
		 

}
