package com.mylearningapp.own.repository;

import com.mylearningapp.own.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
