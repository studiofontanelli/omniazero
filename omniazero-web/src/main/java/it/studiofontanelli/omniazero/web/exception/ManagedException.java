package it.studiofontanelli.omniazero.web.exception;

import org.springframework.http.HttpStatus;

public class ManagedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;
	
	public ManagedException() {
		// TODO Auto-generated constructor stub
	}

	public ManagedException(String message) {
		super(message);
		setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		// TODO Auto-generated constructor stub
	}

	public ManagedException(String message, HttpStatus status) {
		super(message);
		setHttpStatus(status);
		// TODO Auto-generated constructor stub
	}

	public ManagedException(Throwable cause, HttpStatus status) {
		super(cause);
		setHttpStatus(status);
		// TODO Auto-generated constructor stub
	}

	public ManagedException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		setHttpStatus(status);
		// TODO Auto-generated constructor stub
	}

	public ManagedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status) {
		super(message, cause, enableSuppression, writableStackTrace);
		setHttpStatus(status);
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
