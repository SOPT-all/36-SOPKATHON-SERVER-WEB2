package com.sopkathon.teamweb.global.common.dto.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum SuccessCode {

	OK(HttpStatus.OK, "s2000", "요청이 성공했습니다."),
	CREATED(HttpStatus.CREATED, "s2010", "요청이 성공했습니다."),
	NO_CONTENT(HttpStatus.NO_CONTENT, "s2040", "요청이 성공했습니다.");

	private static final Map<HttpStatus, SuccessCode> HTTP_STATUS_CACHE = new ConcurrentHashMap<>();

	static {
		for (SuccessCode successCode : values()) {
			HTTP_STATUS_CACHE.put(successCode.status, successCode);
		}
	}

	private final HttpStatus status;
	private final String code;
	private final String message;

	SuccessCode(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public static SuccessCode valueOf(HttpStatus httpStatus) {
		SuccessCode cachedCode = HTTP_STATUS_CACHE.get(httpStatus);

		if (cachedCode != null) {
			return cachedCode;
		}
		throw new IllegalArgumentException("해당하는 상태 코드가 없습니다: " + httpStatus);
	}

}
