package com.kassmon.common.exceptions;

@SuppressWarnings("serial")
public class ErrorException extends RuntimeException {
	public ErrorException(String message) {
		super(message);
	}

}
