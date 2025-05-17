package com.sopkathon.teamweb.domain.pin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.dto.response.PinGetResponse;
import com.sopkathon.teamweb.domain.pin.repository.PinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PinService {
	private final PinRepository pinRepository;

	public List<PinGetResponse> getPins() {
		List<Pin> pins = pinRepository.findAll();
		return pins.stream().map(
			PinGetResponse::from
		).toList();
	}
}
