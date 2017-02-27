package com.lu.util;

public class BusinessRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessRuntimeException(String msg) {
		super(msg);
	}

	/**
	 * 
	 * @param e
	 */
	public BusinessRuntimeException(Throwable e) {
		super(e);
	}

}

