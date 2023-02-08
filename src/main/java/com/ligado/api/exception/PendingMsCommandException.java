package com.ligado.api.exception;

public class PendingMsCommandException extends Exception {
	private static final long serialVersionUID = -6244539020103668265L;

	public PendingMsCommandException() {
		super();
	}

	public PendingMsCommandException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PendingMsCommandException(String message, Throwable cause) {
		super(message, cause);
	}

	public PendingMsCommandException(String message) {
		super(message);
	}

	public PendingMsCommandException(Throwable cause) {
		super(cause);
	}
}
