package br.com.playground.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@code UnsupportedMathOperationException} indicates that an unsupported
 * mathematical operation was attempted.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception with the specified detail message.
	 *
	 * @param message The detail message.
	 */
	public UnsupportedMathOperationException(String message) {
		super(message);
	}
}