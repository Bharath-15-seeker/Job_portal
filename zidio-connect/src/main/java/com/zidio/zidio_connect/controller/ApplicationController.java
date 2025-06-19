package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.dto.ApplicationApplyRequest;

import com.zidio.zidio_connect.dto.ApplicationResponseDTO;
import com.zidio.zidio_connect.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationResponseDTO> apply(
            @Valid @RequestBody ApplicationApplyRequest request) {

        ApplicationResponseDTO saved = applicationService.apply(request);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(applicationService.getByStudentId(studentId));
    }
}

