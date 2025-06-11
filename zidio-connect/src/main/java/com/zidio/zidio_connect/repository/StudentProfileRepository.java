package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByUserId(Long userId);
}
