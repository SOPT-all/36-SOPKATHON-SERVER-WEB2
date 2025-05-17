package com.sopkathon.teamweb.domain.pin.dto.response;

import com.sopkathon.teamweb.domain.pin.domain.Pin;

public record PinGetResponse(
	long pinId,
	double latitude,
	double longitude,
	String image,
	String content,
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
			pin.getLikeRate(),
			pin.getHateRate()
		);
	}
}
