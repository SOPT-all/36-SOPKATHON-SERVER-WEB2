package com.sopkathon.teamweb.domain.vote;

import static com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode.*;

import com.sopkathon.teamweb.global.common.exception.BusinessException;
import com.sopkathon.teamweb.global.common.exception.constant.ExceptionCode;

public class AlreadyVotedException extends BusinessException {
	public AlreadyVotedException(){
		super(ALREADY_VOTED);
	}
}
