package com.sopkathon.teamweb.domain.pin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopkathon.teamweb.domain.pin.dto.response.PinAllGetResponse;
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
}
