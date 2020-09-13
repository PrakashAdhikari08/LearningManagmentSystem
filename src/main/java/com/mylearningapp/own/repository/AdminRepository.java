package com.mylearningapp.own.repository;

import com.mylearningapp.own.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
