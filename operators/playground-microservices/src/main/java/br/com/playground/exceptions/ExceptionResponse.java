package br.com.playground.exceptions;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO to receive the exception response.
 */
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Date of the exception.
	 */
	private Date timeStamp;

	/**
	 * Message of the exception.
	 */
	private String message;

	/**
	 * Details of the exception.
	 */
	private String details;

	/**
	 * {@code ExceptionResponse} constructor.
	 * 
	 * @param timeStamp Date of the exception.
	 * @param message   Message of the exception.
	 * @param details   Details of the exception.
	 */
	public ExceptionResponse(Date timeStamp, String message, String details) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimestamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
