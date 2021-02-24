package com.ritesh.rest.webServices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ritesh.rest.webServices.restfulwebservices.user.UserNotFoundException;

//now to make this class common to all controller
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	//now I want this to happen whenever the exception happens that is for all kind of exceptions
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionResponse execption = new ExceptionResponse(new Date(), ex.getMessage(), null);
		return new ResponseEntity(execption, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//now I want below method to run when user not found exception happens so
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse usernotfoundexception = new ExceptionResponse(new Date(), ex.getMessage(), null);
		return new ResponseEntity<Object>(usernotfoundexception, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse usernotfoundexception = new ExceptionResponse(new Date(), "Invalid String Length", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(usernotfoundexception, HttpStatus.BAD_REQUEST);
	}

}
