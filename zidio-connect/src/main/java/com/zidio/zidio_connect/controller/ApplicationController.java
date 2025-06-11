package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.model.Application;
import com.zidio.zidio_connect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody Application application) {
        return ResponseEntity.ok(applicationService.apply(application));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(applicationService.getByStudentId(studentId));
    }
}

