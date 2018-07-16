package com.ebox.exception;

 

public class deviceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	private boolean propertiesKey = true;
	
	public deviceException(String message)
	{
		           super(message);
		    }

	 public deviceException(String errorCode, String message, boolean propertiesKey)
	     {
	           super(message);
	           this.setErrorCode(errorCode);
	           this.setPropertiesKey(propertiesKey);
	       }
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isPropertiesKey() {
		return propertiesKey;
	}

	public void setPropertiesKey(boolean propertiesKey) {
		this.propertiesKey = propertiesKey;
	}
	
 
	 
}