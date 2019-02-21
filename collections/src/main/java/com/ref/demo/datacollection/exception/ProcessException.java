package com.ref.demo.datacollection.exception;

public class ProcessException extends Exception {
	/**
	 * 
	*/
	private static final long serialVersionUID = 1L;
	
	private final String message ;
	
	/**
	 * @param message from class
	 * @return Message string for user
	 */
	public ProcessException(final String message){
		this.message = message ;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
