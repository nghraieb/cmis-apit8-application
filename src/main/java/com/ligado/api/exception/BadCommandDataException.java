package com.ligado.api.exception;

public class BadCommandDataException extends Exception {
	public BadCommandDataException() {
		super();
	}

	public BadCommandDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BadCommandDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadCommandDataException(String message) {
		super(message);
	}

	public BadCommandDataException(Throwable cause) {
		super(cause);
	}
}
