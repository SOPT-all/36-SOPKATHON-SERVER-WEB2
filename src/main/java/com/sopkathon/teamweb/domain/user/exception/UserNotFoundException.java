package com.sopkathon.teamweb.domain.user.exception;

import static com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode.*;

import com.sopkathon.teamweb.global.common.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
	public UserNotFoundException() {
		super(USER_NOT_FOUND);
	}
}
