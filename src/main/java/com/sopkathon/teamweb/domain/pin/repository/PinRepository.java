package com.sopkathon.teamweb.domain.pin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.teamweb.domain.pin.domain.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {
}
