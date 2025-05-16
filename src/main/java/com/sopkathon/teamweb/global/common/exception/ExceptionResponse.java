package com.sopkathon.teamweb.global.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExceptionResponse(String code, String message) {

	public static ExceptionResponse of(ExceptionCode exceptionCode) {
		return new ExceptionResponse(
			exceptionCode.getCode(),
			exceptionCode.getMessage()
		);
	}

	public static ExceptionResponse from(ExceptionCode exceptionCode, String message) {
		return new ExceptionResponse(
			exceptionCode.getCode(),
			message
		);
	}
}
