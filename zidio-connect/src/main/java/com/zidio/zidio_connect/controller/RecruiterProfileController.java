package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.dto.RecruiterProfileRequest;
import com.zidio.zidio_connect.dto.RecruiterProfileResponse;
import com.zidio.zidio_connect.service.RecruiterProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiter")
@RequiredArgsConstructor
public class RecruiterProfileController {

    private final RecruiterProfileService recruiterService;


    @PostMapping("/save")
    @PreAuthorize("hasRole('RECRUITER')")          // gate it however you like
    public ResponseEntity<RecruiterProfileResponse> saveProfile(
            @Valid @RequestBody RecruiterProfileRequest request) {

        RecruiterProfileResponse saved = recruiterService.saveProfile(request);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/company/{companyName}")
    public ResponseEntity<RecruiterProfileResponse> getByCompany(
            @PathVariable String companyName) {

        return ResponseEntity.ok(recruiterService.getByCompanyName(companyName));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<RecruiterProfileResponse> getByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(recruiterService.getByUserId(userId));
    }
}
