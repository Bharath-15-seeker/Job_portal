package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientId(Long userId);
}

