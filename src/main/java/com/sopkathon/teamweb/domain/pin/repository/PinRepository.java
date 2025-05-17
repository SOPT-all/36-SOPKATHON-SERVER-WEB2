package com.sopkathon.teamweb.domain.pin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sopkathon.teamweb.domain.pin.domain.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {

	@Query("SELECT p.region as region, " +
		"AVG(CASE WHEN (p.likeCount + p.hateCount) > 0 " +
		"THEN (p.likeCount * 100.0 / (p.likeCount + p.hateCount)) ELSE 0 END) as avgLikeRate " +
		"FROM Pin p " +
		"GROUP BY p.region " +
		"ORDER BY avgLikeRate DESC")
	List<Object[]> findRegionsOrderByAvgLikeRate();
}
