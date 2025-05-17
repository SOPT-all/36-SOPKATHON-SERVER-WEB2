package com.sopkathon.teamweb.domain.pin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateRequest;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateResponse;
import com.sopkathon.teamweb.domain.pin.domain.constant.Region;
import com.sopkathon.teamweb.domain.pin.dto.response.PinAllGetResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinGetResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinSimpleResponse;
import com.sopkathon.teamweb.domain.pin.dto.response.PinVoteRequest;
import com.sopkathon.teamweb.domain.pin.excepiton.PinNotFoundException;
import com.sopkathon.teamweb.domain.pin.repository.PinRepository;
import com.sopkathon.teamweb.domain.user.domain.User;
import com.sopkathon.teamweb.domain.user.exception.UserNotFoundException;
import com.sopkathon.teamweb.domain.user.repository.UserRepository;
import com.sopkathon.teamweb.domain.vote.AlreadyVotedException;
import com.sopkathon.teamweb.domain.vote.domain.Vote;
import com.sopkathon.teamweb.domain.vote.repository.VoteRepository;
import com.sopkathon.teamweb.infra.S3Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PinService {
	private final PinRepository pinRepository;
	private final VoteRepository voteRepository;
	private final UserRepository userRepository;
	private final S3Service s3Service;

	public PinGetResponse getPinDetail(long pinId) {
		Pin pin = pinRepository.findById(pinId).orElseThrow(PinNotFoundException::new);

		return PinGetResponse.from(pin);
	}

	public List<PinAllGetResponse> getPinAll() {
		List<Pin> pins = pinRepository.findAll();

		return pins.stream().map(
			PinAllGetResponse::from
		).toList();
	}

	public List<String> getRegionRank() {
		List<Object[]> results = pinRepository.findRegionsOrderByAvgLikeRate();

		return results.stream()
			.map(result -> Region.getName(result[0]))
			.toList();
	}

	@Transactional
	public PinCreateResponse createPin(PinCreateRequest req, long userId) {
		User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

		//해당  url을 pin에 넣기


		Pin pin = Pin.makePin(req.isLike(), req.placeName(), req.oneliner(),
			req.latitude(), req.longitude(), req.imageUrl(), req.reviews(),
			req.region(),user);

		pinRepository.save(pin);

		return PinCreateResponse.from(pin);
	}

	@Transactional
	public PinSimpleResponse votePin(Long userId, Long pinId, PinVoteRequest pinVoteRequest) {

		User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
		Pin pin = pinRepository.findById(pinId).orElseThrow(PinNotFoundException::new);

		// 해당 유저가 pin 에 이미 투표 했는지 확인
		boolean voted = voteRepository.existsByUserAndPin(user, pin);

		// 이미 투표했다면 ,예외 반환
		if (voted) {
			throw new AlreadyVotedException();
		}

		boolean isLike = pinVoteRequest.isLike();

		Vote vote = Vote.builder()
			.user(user)
			.pin(pin)
			.isLike(isLike)
			.build();

		if (isLike) {
			pin.increaseLikeCount();
		} else {
			pin.increaseHateCount();
		}

		voteRepository.save(vote);

		return PinSimpleResponse.from(pin);

	}
}
