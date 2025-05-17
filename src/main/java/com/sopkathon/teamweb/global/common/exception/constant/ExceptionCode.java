package com.sopkathon.teamweb.global.common.exception.constant;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ExceptionCode {

	//400
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "c4000", "잘못된 요청입니다."),
	EMPTY_USER_ID(HttpStatus.BAD_REQUEST, "c40010", "유저ID는 필수입니다."),

	//404
	NOT_FOUND(HttpStatus.NOT_FOUND, "c4040", "리소스가 존재하지 않습니다."),
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "c4042", "사용자가 존재하지 않습니다."),
	PIN_NOT_FOUND(HttpStatus.NOT_FOUND, "c4043", "핀이 존재하지 않습니다."),

	//405
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "c4050", "잘못된 HTTP method 요청입니다."),

	//409
	DUPLICATE(HttpStatus.CONFLICT, "c4090", "이미 존재하는 리소스입니다."),

	//500
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "c5000", "서버 내부 오류가 발생했습니다.");

	private final HttpStatus status;
	private final String code;
	private final String message;

	ExceptionCode(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

}
