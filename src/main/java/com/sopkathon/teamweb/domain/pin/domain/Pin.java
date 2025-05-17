package com.sopkathon.teamweb.domain.pin.domain;

import java.util.List;

import com.sopkathon.teamweb.domain.pin.domain.constant.Region;
import com.sopkathon.teamweb.domain.pin.domain.constant.Review;
import com.sopkathon.teamweb.domain.user.domain.User;
import com.sopkathon.teamweb.global.common.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pins")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Pin extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String placeName;

	private String oneliner;

	private Double latitude;

	private Double longitude;

	private String image;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User author;

	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.LAZY)
	private List<Review> reviews;

	@Enumerated(EnumType.STRING)
	private Region region;
}
