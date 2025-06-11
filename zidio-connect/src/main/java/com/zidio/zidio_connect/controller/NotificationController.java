package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.model.Notification;
import com.zidio.zidio_connect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationsByUserId(userId));
    }

    @PostMapping("/send")
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.sendNotification(notification));
    }
}
