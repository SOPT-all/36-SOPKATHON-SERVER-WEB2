package com.sopkathon.teamweb.domain.pin.dto.response;

import java.util.List;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.domain.constant.Review;

public record PinGetResponse(
	long pinId,
	double latitude,
	double longitude,
	String image,
	String oneLiner,
	List<Review> reviews,
	long likeRate,
	long hateLate
) {
	public static PinGetResponse from(Pin pin) {
		return new PinGetResponse(
			pin.getId(),
			pin.getLatitude(),
			pin.getLongitude(),
			pin.getImage(),
			pin.getOneliner(),
			pin.getReviews(),
			pin.getLikeRate(),
			pin.getHateRate()
		);
	}
}
