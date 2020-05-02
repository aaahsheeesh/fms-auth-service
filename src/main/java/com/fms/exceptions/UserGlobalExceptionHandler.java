package com.fms.exceptions;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fms.dto.ResponseDTO;


@ControllerAdvice
public class UserGlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(UserNotFoundException.class)
//	protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		ResponseDTO<Object> errorResponse = new ResponseDTO<>();
//		errorResponse.setStatus(false);
//		errorResponse.setMessage("User not found");
//		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ResponseDTO<Object> errorResponse = new ResponseDTO<>();
		errorResponse.setStatus(false);
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		errorResponse.setMessage(errors.get(0));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

}
