package com.msk.photoapi.users.ms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

	
	
	
	@ExceptionHandler(value = {Exception.class})
	public final ResponseEntity<String> ab(HttpServletRequest req, Exception excep) {
		
		return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
		
	}
	
}
