package com.sopkathon.teamweb.infra.exception;

import static com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode.*;

import com.sopkathon.teamweb.global.common.exception.BusinessException;
import com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode;

public class ImageUploadFailException extends BusinessException {
	public ImageUploadFailException() {
		super(IMAGE_UPLOAD_FAIL);
	}
}
