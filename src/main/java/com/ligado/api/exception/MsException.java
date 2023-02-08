package com.ligado.api.exception;

public class MsException extends Exception {

	public MsException() {
		super();
	}

	public MsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MsException(String message, Throwable cause) {
		super(message, cause);
	}

	public MsException(String message) {
		super(message);
	}

	public MsException(Throwable cause) {
		super(cause);
	}

}
