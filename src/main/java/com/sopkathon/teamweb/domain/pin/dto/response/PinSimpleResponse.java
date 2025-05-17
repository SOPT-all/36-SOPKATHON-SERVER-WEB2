package com.sopkathon.teamweb.domain.pin.dto.response;

import java.util.List;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.domain.constant.Review;

public record PinSimpleResponse(
	long pinId,
	String image,
	List<Review> reviews,
	long likeRate,
	long hateLate
) {

	public static PinSimpleResponse from(Pin pin) {
		return new PinSimpleResponse(
			pin.getId(),
			pin.getImage(),
			pin.getReviews(),
			pin.getLikeRate(),
			pin.getHateRate()
		);
	}
}
