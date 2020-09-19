package com.mylearningapp.own.repository;

import com.mylearningapp.own.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String email);

    Optional<User> findByResetToken(String token);
}
