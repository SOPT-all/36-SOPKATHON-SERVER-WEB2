package com.sopkathon.teamweb.domain.pin.service;

import org.springframework.stereotype.Service;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateRequest;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateResponse;
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

	public PinCreateResponse createPin(PinCreateRequest req) {
		Pin pin = Pin.makePin(req.isCorrect(), req.placeName(),req.oneliner(),
			req.latitude(), req.longitude(), req.image(), req.reviews(),
			req.region());

		pinRepository.save(pin);

		return PinCreateResponse.from(pin);
	}
}
