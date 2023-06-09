package com.in28min.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28min.rest.webservices.restfulwebservices.user.UserNotFoundException;
@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class) //to take all the exceptions
	public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class) //to take all the exceptions
	public final ResponseEntity<Object> handleExceptionsUserNotFound(Exception ex, WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetails errorDetails= new ErrorDetails(LocalDate.now(),
				//ex.getMessage(
						"Total Errors: " + ex.getErrorCount() + " Details " + ex.getFieldError().getDefaultMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}






}