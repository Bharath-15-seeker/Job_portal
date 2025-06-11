package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.ChatMessage;
import com.zidio.zidio_connect.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getMessagesByRecipient(Long recipientId) {
        return chatMessageRepository.findByRecipientId(recipientId);
    }

    public List<ChatMessage> getMessagesBySender(Long senderId) {
        return chatMessageRepository.findBySenderId(senderId);
    }

    public ChatMessage sendMessage(ChatMessage message) {
        message.setSentAt(LocalDateTime.now());
        message.setRead(false);
        return chatMessageRepository.save(message);
    }
}
