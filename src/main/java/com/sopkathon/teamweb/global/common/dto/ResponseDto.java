package com.sopkathon.teamweb.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopkathon.teamweb.global.common.dto.constant.SuccessCode;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
	private final String code;
	private final String message;
	private final T data;

	private ResponseDto(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static <T> ResponseDto<T> of(SuccessCode successCode, T data) {
		return new ResponseDto<>(successCode.getCode(), successCode.getMessage(), data);
	}

	public static <T> ResponseDto<T> ok(T data) {
		return of(SuccessCode.OK, data);
	}

	public static ResponseDto<Void> noContent() {
		return of(SuccessCode.NO_CONTENT, null);
	}

	public static <T> ResponseDto<T> created(T data) {
		return of(SuccessCode.CREATED, data);
	}

}
