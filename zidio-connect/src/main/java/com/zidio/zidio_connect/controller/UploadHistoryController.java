package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.model.UploadHistory;
import com.zidio.zidio_connect.service.UploadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uploads")
public class UploadHistoryController {

    @Autowired
    private UploadHistoryService uploadHistoryService;

    @PostMapping("/save")
    public ResponseEntity<UploadHistory> save(@RequestBody UploadHistory uploadHistory) {
        return ResponseEntity.ok(uploadHistoryService.saveUploadHistory(uploadHistory));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UploadHistory>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(uploadHistoryService.getUploadsByUser(userId));
    }
}
