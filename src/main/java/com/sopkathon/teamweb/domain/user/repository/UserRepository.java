package com.sopkathon.teamweb.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.teamweb.domain.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
