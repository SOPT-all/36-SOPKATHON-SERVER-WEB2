package com.sopkathon.teamweb.domain.pin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopkathon.teamweb.domain.pin.dto.response.PinAllGetResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateRequest;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinGetResponse;
import com.sopkathon.teamweb.domain.pin.service.PinService;
import com.sopkathon.teamweb.global.common.dto.ResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pins")
@RequiredArgsConstructor
public class PinController {
	private final PinService pinService;

	@GetMapping("/detail")
	public ResponseDto<PinGetResponse> getPinDetail(@RequestHeader Long pinId) {
		PinGetResponse response = pinService.getPinDetail(pinId);

		return ResponseDto.ok(response);
	}

	@GetMapping
	public ResponseDto<List<PinAllGetResponse>> getPinAll() {
		List<PinAllGetResponse> responses = pinService.getPinAll();

		return ResponseDto.ok(responses);
	}

	@GetMapping("/regions")
	public ResponseDto<List<String>> getRegionRank() {
		List<String> responses = pinService.getRegionRank();

		return ResponseDto.ok(responses);
	}


	@PostMapping
	public ResponseDto<PinCreateResponse> createPin(@RequestBody PinCreateRequest createRequest) {

		PinCreateResponse response = pinService.createPin(createRequest);

		return ResponseDto.created(response);
	}
}
