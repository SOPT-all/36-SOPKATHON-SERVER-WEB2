package com.sopkathon.teamweb.domain.pin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import com.sopkathon.teamweb.domain.pin.dto.response.PinSimpleResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinVoteRequest;
import com.sopkathon.teamweb.domain.pin.service.PinService;
import com.sopkathon.teamweb.global.common.dto.ResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pins")
@RequiredArgsConstructor
public class PinController {
	private final PinService pinService;

	@GetMapping("/detail/{pinId}")
	public ResponseDto<PinGetResponse> getPinDetail(@PathVariable Long pinId) {
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
	public ResponseDto<PinCreateResponse> createPin(
		@RequestHeader Long userId,
		@RequestBody PinCreateRequest createRequest) {

		PinCreateResponse response = pinService.createPin(createRequest, userId);

		return ResponseDto.created(response);
	}

	@PatchMapping("/{userId}/{pinId}")
	public ResponseDto<PinSimpleResponse> votePin(@PathVariable("userId") Long userId,
		@PathVariable("pinId") Long pinId, @RequestBody PinVoteRequest pinVoteRequest) {

		PinSimpleResponse response = pinService.votePin(userId, pinId, pinVoteRequest);
		return ResponseDto.ok(response);
	}

}
