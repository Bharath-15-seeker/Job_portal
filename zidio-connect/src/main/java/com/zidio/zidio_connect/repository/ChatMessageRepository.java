package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndRecipientId(Long senderId, Long recipientId);

    List<ChatMessage> findByRecipientId(Long recipientId);

    List<ChatMessage> findBySenderId(Long senderId);
}
