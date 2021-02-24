package com.igrejaApp.Exceptions;

public class InvalidFieldException extends Exception {

	
	private static final long serialVersionUID = 888305738690164709L;

	public InvalidFieldException(String message, Object... args) {
		this(String.format(message, args));
	}

	public InvalidFieldException(String message) {
		super(message);
	}

	public InvalidFieldException(Throwable cause) {
		super(cause);
	}

	public InvalidFieldException() {
		super();
	}
}
