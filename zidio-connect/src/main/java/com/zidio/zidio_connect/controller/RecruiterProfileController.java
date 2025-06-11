package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.dto.RecruiterProfileDTO;
import com.zidio.zidio_connect.model.RecruiterProfile;
import com.zidio.zidio_connect.service.RecruiterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterProfileController {

    @Autowired
    private RecruiterProfileService recruiterService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProfile(@RequestBody RecruiterProfile recruiter) {
        return ResponseEntity.ok(recruiterService.saveProfile(recruiter));
    }

    @GetMapping("/company/{companyName}")
    public ResponseEntity<?> getByCompany(@PathVariable String companyName) {
        return ResponseEntity.ok(recruiterService.getByCompanyName(companyName));
    }
}

