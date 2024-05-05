package br.com.playground.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.playground.exceptions.ExceptionResponse;
import br.com.playground.exceptions.ResourceNotFoundException;

/**
 * CustomizedResponseEntityExceptionHandler is a custom exception handler that
 * extends ResponseEntityExceptionHandler.
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler /* */
		extends ResponseEntityExceptionHandler {

	/**
	 * Handles all types of exceptions thrown within the application.
	 * 
	 * @param ex      The exception to be handled.
	 * @param request The HTTP request that resulted in the exception.
	 * 
	 * @return A ResponseEntity containing the error response for the bad request
	 *         with status code 500 (INTERNAL_SERVER_ERROR).
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse>/* */
			handlerAllException(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = /* */
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handle exceptions related to incorrect requests, specifically those caused by
	 * not found.
	 * 
	 * @param ex      The exception to be handled.
	 * @param request The HTTP request that resulted in the exception.
	 * 
	 * @return A ResponseEntity with HTTP status code 400 (Bad Request) containing
	 *         the error response for the bad request.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse>/* */
			handlerNotFoundExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = /* */
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}