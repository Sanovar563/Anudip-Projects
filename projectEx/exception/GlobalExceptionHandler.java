package com.example.demo.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@SuppressWarnings("serial")
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationError(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

private Map<String, List<String>> getErrorMap(List<String> errors) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}

// user not found exception
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, List<String>>> handleNotFoundException(UserNotFoundException unfex) {
		List<String> errors = Collections.singletonList(unfex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);

	}

// Customer not found exception
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, List<String>>> handleNotFoundException(CustomerNotFoundException cnfex) {
		List<String> errors = Collections.singletonList(cnfex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);

	}

}
