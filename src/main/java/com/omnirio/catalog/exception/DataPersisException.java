package com.omnirio.catalog.exception;

public class DataPersisException extends RuntimeException{
	
	 public DataPersisException() {
	        super();
	    }
	    public DataPersisException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public DataPersisException(String message) {
	        super(message);
	    }
	    public DataPersisException(Throwable cause) {
	        super(cause);
	    }

}
