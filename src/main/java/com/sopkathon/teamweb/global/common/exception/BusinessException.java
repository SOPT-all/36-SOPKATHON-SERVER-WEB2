package com.sopkathon.teamweb.global.common.exception;

import com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode;

public class BusinessException extends RuntimeException {

	private final ExceptionCode exceptionCode;

	public BusinessException(ExceptionCode exceptionCode) {
		super(exceptionCode.getMessage());
		this.exceptionCode = exceptionCode;
	}

	public ExceptionCode getErrorCode() {
		return exceptionCode;
	}
}
