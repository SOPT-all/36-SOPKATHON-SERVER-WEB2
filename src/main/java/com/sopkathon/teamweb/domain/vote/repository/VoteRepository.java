package com.sopkathon.teamweb.domain.vote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.user.domain.User;
import com.sopkathon.teamweb.domain.vote.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

	boolean existsByUserAndPin(User user, Pin pin);

}
