package com.sunshine.PSC.service.exception;

public class DateInvalidException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	
	public DateInvalidException(String msg) {
		super(msg);
	}

	public DateInvalidException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
