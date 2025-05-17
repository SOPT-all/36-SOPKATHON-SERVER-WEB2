package com.sopkathon.teamweb.domain.pin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.dto.response.PinAllGetResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinGetResponse;
import com.sopkathon.teamweb.domain.pin.repository.PinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PinService {
	private final PinRepository pinRepository;

	public PinGetResponse getPinDetail(long pinId) {
		Pin pin = pinRepository.findById(pinId).get();

		return PinGetResponse.from(pin);
	}

	public List<PinAllGetResponse> getPinAll() {
		List<Pin> pins = pinRepository.findAll();

		return pins.stream().map(
			PinAllGetResponse::from
		).toList();
	}
}
