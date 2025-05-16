package com.sopkathon.teamweb.global.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException ex) {
		ExceptionCode exceptionCode = ex.getErrorCode();
		ExceptionResponse exceptionResponse = ExceptionResponse.of(exceptionCode);
		return new ResponseEntity<>(exceptionResponse, exceptionCode.getStatus());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		ExceptionResponse exceptionResponse = ExceptionResponse.from(ExceptionCode.INVALID_INPUT_VALUE, errorMessage);
		return new ResponseEntity<>(exceptionResponse, ExceptionCode.INVALID_INPUT_VALUE.getStatus());
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoHandlerFoundException() {
		ExceptionResponse exceptionResponse = ExceptionResponse.of(ExceptionCode.NOT_FOUND);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupportedException() {
		ExceptionResponse exceptionResponse = ExceptionResponse.of(ExceptionCode.METHOD_NOT_ALLOWED);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleException(Exception e) {
		ExceptionResponse exceptionResponse = ExceptionResponse.of(ExceptionCode.INTERNAL_SERVER_ERROR);
		log.info(e.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ExceptionResponse> handleMissingHeaderException(MissingRequestHeaderException e) {

		if (e.getHeaderName().equals("userId")) {
			ExceptionResponse response = ExceptionResponse.of(ExceptionCode.EMPTY_USER_ID);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		log.info("필드 누락: " + e.getHeaderName());
		ExceptionResponse response = ExceptionResponse.of(ExceptionCode.INVALID_INPUT_VALUE);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
