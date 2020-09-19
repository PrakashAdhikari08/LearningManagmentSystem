package com.mylearningapp.own.repository;

import com.mylearningapp.own.contact.ContactUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUsEntity, Long> {
}
