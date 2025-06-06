package com.sopkathon.teamweb.domain.pin.domain;

import java.util.List;

import com.sopkathon.teamweb.domain.pin.domain.constant.DefaultMark;
import com.sopkathon.teamweb.domain.pin.domain.constant.Region;
import com.sopkathon.teamweb.domain.pin.domain.constant.Review;
import com.sopkathon.teamweb.domain.pin.dto.response.PinCreateRequest;
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
import lombok.Builder;
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

	private String oneliner; // 한 줄 평가

	private Double latitude;

	private Double longitude;

	private String image;

	private long likeCount;

	private long hateCount;

	@Enumerated(EnumType.STRING)
	private DefaultMark defaultMark; // 생성시 O,X 표시

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User author;

	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.LAZY)
	private List<Review> reviews;

	@Enumerated(EnumType.STRING)
	private Region region;

	private long getTotal() {
		return this.likeCount + this.hateCount;
	}

	public long getLikeRate() {
		long likes = this.likeCount;
		long total = getTotal();

		return total > 0 ? Math.round((double)likes / total * 100) : 0;
	}

	public long getHateRate() {
		long hates = this.hateCount;
		long total = getTotal();

		return total > 0 ? Math.round((double)hates / total * 100) : 0;
	}

	public void increaseLikeCount() {
		this.likeCount += 1;
	}

	public void increaseHateCount() {
		this.hateCount += 1;

	}

	@Builder
	public Pin(String placeName, String oneliner, Double latitude, Double longitude, String image, long likeCount,
		long hateCount, DefaultMark defaultMark, User author, List<Review> reviews, Region region) {
		this.placeName = placeName;
		this.oneliner = oneliner;
		this.latitude = latitude;
		this.longitude = longitude;
		this.image = image;
		this.likeCount = likeCount;
		this.hateCount = hateCount;
		this.defaultMark = defaultMark;
		this.author = author;
		this.reviews = reviews;
		this.region = region;
	}

	public static Pin makePin(boolean isCorrect, String placeName, String oneliner, double latitude,
		double longitude, String image, List<Review> reviews, Region region, User user) {

		//isCorrect 가 1 이면 DefaultMark 를 O로 설정
		DefaultMark mark = isCorrect ? DefaultMark.O : DefaultMark.X;

		long likeCount = isCorrect ? 1L : 0L;
		long hateCount = isCorrect ? 0L : 1L;

		return Pin.builder()
			.placeName(placeName)
			.oneliner(oneliner)
			.latitude(latitude)
			.longitude(longitude)
			.image(image)
			.likeCount(likeCount) // 기본값
			.hateCount(hateCount) // 기본값
			.defaultMark(mark) // enum 기본값 또는 null 가능
			.reviews(reviews)
			.region(region)
			.author(user)
			.build();
	}


}

