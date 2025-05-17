package com.sopkathon.teamweb.domain.pin.dto.response;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.domain.constant.DefaultMark;

public record PinAllGetResponse(
	long pinId,
	double latitude,
	double longitude,
	DefaultMark defaultMark
) {
	public static PinAllGetResponse from(Pin pin) {
		return new PinAllGetResponse(
			pin.getId(),
			pin.getLatitude(),
			pin.getLongitude(),
			pin.getDefaultMark()
		);
	}
}
