package com.sopkathon.teamweb.domain.vote.domain;

import com.sopkathon.teamweb.domain.pin.domain.Pin;
import com.sopkathon.teamweb.domain.user.domain.User;
import com.sopkathon.teamweb.global.common.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "votes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Vote extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "pin_id")
	private Pin pin;

	private boolean isLike; // true: 맞아유, false: 아니여유

	@Builder
	public Vote(User user, Pin pin, boolean isLike) {
		this.user = user;
		this.pin = pin;
		this.isLike = isLike;
	}

	// 투표 변경 메서드
	public void updateVote(boolean isLike) {
		this.isLike = isLike;
	}

}
