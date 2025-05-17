package com.sopkathon.teamweb.domain.pin.dto.response;

import java.util.List;

import com.sopkathon.teamweb.domain.pin.domain.constant.Region;
import com.sopkathon.teamweb.domain.pin.domain.constant.Review;

public record PinCreateRequest(
	boolean isCorrect,
	String image,
	Region region,
	String placeName,
	double latitude,
	double longitude,
	List<Review> reviews, // 평가칩 여러개
	String oneliner
) {


}
