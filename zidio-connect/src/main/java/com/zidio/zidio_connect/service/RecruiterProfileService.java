package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.RecruiterProfile;
import com.zidio.zidio_connect.repository.RecruiterProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {
    @Autowired
    private RecruiterProfileRepository recruiterRepo;

    public Optional<RecruiterProfile> getByUserId(Long userId) {
        return recruiterRepo.findByUserId(userId);
    }

    public RecruiterProfile saveProfile(RecruiterProfile profile) {
        return recruiterRepo.save(profile);
    }

    public Optional<RecruiterProfile> getByCompanyName(String companyName) {
        return recruiterRepo.findByCompanyName(companyName);
    }

}
