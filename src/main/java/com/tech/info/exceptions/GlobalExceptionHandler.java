package com.tech.info.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.info.utils.ResponceApi;

import jakarta.el.MethodNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ResponceApi> resourceNotFoundExceptionHandler(ResourceNotFoundException notFoundException){
		String message = notFoundException.getMessage();
		ResponceApi api = new ResponceApi(message, false);
		return new ResponseEntity<ResponceApi>(api, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<Map<String, String>> handleMethodNotFoundException(MethodArgumentNotValidException exception){
		Map<String, String> map = new HashMap<>();
		
		exception.getBindingResult().getAllErrors().forEach((error)->{
			
			String message = error.getDefaultMessage();
			String field = ((FieldError)error).getField();
			
			map.put(message, field);
		});
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
		
		
	}
	

}
