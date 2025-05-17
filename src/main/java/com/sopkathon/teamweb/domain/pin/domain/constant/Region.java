package com.sopkathon.teamweb.domain.pin.domain.constant;

import java.util.Arrays;

public enum Region {
	청주시, 충주시;

	// String으로부터 Region을 찾는 정적 메서드
	public static Region fromString(String value) {
		if (value == null) {
			return null;
		}

		return Arrays.stream(Region.values())
			.filter(region -> region.name().equals(value))
			.findFirst()
			.orElse(null);
	}

	// 안전하게 Region을 String으로 변환하는 정적 메서드
	public static String getName(Object regionObj) {
		if (regionObj == null) {
			return null;
		}

		if (regionObj instanceof Region) {
			return ((Region)regionObj).name();
		}

		if (regionObj instanceof String) {
			return (String)regionObj;
		}

		// 문자열로 변환 시도
		try {
			Region region = fromString(regionObj.toString());
			return region != null ? region.name() : regionObj.toString();
		} catch (Exception e) {
			return regionObj.toString();
		}
	}
}
