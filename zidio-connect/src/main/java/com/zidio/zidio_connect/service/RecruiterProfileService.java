package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.dto.RecruiterProfileRequest;
import com.zidio.zidio_connect.dto.RecruiterProfileResponse;
import com.zidio.zidio_connect.model.RecruiterProfile;
import com.zidio.zidio_connect.repository.RecruiterProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruiterProfileService {

    private final RecruiterProfileRepository repo;

    @Transactional
    public RecruiterProfileResponse saveProfile(RecruiterProfileRequest dto) {


        RecruiterProfile entity = repo.findByUserId(dto.getUserId())
                .orElse(new RecruiterProfile());

        entity.setUserId(dto.getUserId());
        entity.setCompanyName(dto.getCompanyName());
        entity.setDesignation(dto.getDesignation());
        entity.setCompanyWebsite(dto.getCompanyWebsite());


        RecruiterProfile saved = repo.save(entity);
        return mapToResponse(saved);
    }

    @Transactional(readOnly = true)
    public RecruiterProfileResponse getByCompanyName(String companyName) {

        RecruiterProfile profile = repo.findByCompanyName(companyName)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No recruiter profile for company: " + companyName));

        return mapToResponse(profile);
    }


    @Transactional(readOnly = true)
    public RecruiterProfileResponse getByUserId(Long userId) {

        RecruiterProfile profile = repo.findByUserId(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No recruiter profile for user‑id: " + userId));

        return mapToResponse(profile);
    }

    private RecruiterProfileResponse mapToResponse(RecruiterProfile p) {
        RecruiterProfileResponse r = new RecruiterProfileResponse();
        r.setId(p.getId());
        r.setUserId(p.getUserId());
        r.setCompanyName(p.getCompanyName());
        r.setDesignation(p.getDesignation());
        r.setCompanyWebsite(p.getCompanyWebsite());
        r.setVersion(p.getVersion());
        return r;
    }
}
