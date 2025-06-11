package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Long> {
    Optional<RecruiterProfile> findByUserId(Long userId);

    Optional<RecruiterProfile> findByCompanyName(String companyName);
}
