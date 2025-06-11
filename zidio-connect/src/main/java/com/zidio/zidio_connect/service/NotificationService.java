package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.Notification;
import com.zidio.zidio_connect.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByRecipientId(userId);
    }

    public Notification sendNotification(Notification notification) {
        notification.setRead(false);
        notification.setTimestamp(java.time.LocalDateTime.now());
        return notificationRepository.save(notification);
    }
}
