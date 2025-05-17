package com.sopkathon.teamweb.domain.image;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sopkathon.teamweb.global.common.dto.ResponseDto;
import com.sopkathon.teamweb.infra.S3Service;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImageController {

	private final S3Service s3Service;

	@PostMapping(value = "/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseDto<String> upload(@RequestPart MultipartFile image){
		String imageUrl = s3Service.upload(image, "images");
		return ResponseDto.ok(imageUrl);
	}
}
