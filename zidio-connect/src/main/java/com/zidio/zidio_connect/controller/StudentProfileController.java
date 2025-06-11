package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.dto.StudentProfileRequest;
import com.zidio.zidio_connect.model.StudentProfile;
import com.zidio.zidio_connect.service.StudentProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")

public class StudentProfileController {
    @Autowired
    private  StudentProfileService studentProfileService;

    @PostMapping("/save")
    public ResponseEntity<StudentProfile> createProfile(@Valid @RequestBody StudentProfileRequest request) {
        StudentProfile profile = studentProfileService.createStudentProfile(request);
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(studentProfileService.getByUserId(userId));
    }
}

