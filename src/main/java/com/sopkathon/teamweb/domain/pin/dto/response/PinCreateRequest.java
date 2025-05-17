package com.sopkathon.teamweb.domain.pin.dto.response;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sopkathon.teamweb.domain.pin.domain.constant.Region;
import com.sopkathon.teamweb.domain.pin.domain.constant.Review;

public record PinCreateRequest(
	boolean isLike,
	Region region,
	String placeName,
	String imageUrl,
	double latitude,
	double longitude,
	List<Review> reviews, // 평가칩 여러개
	String oneliner
) {


}
