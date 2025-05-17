package com.sopkathon.teamweb.domain.pin.excepiton;

import static com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode.*;

import com.sopkathon.teamweb.global.common.exception.BusinessException;

public class PinNotFoundException extends BusinessException {
	public PinNotFoundException() {
		super(PIN_NOT_FOUND);

	}
}
