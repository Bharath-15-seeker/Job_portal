package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.model.AdminActionLog;
import com.zidio.zidio_connect.service.AdminActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/logs")
public class AdminActionLogController {

    @Autowired
    private AdminActionLogService adminActionLogService;

    @PostMapping("/add")
    public ResponseEntity<AdminActionLog> logAction(@RequestBody AdminActionLog log) {
        return ResponseEntity.ok(adminActionLogService.logAction(log));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminActionLog>> getAllLogs() {
        return ResponseEntity.ok(adminActionLogService.getAllLogs());
    }

    @GetMapping("/by-admin/{adminId}")
    public ResponseEntity<List<AdminActionLog>> getLogsByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(adminActionLogService.getLogsByAdmin(adminId));
    }
}
