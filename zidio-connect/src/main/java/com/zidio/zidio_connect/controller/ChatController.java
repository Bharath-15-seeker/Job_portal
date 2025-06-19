package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.model.ChatMessage;
import com.zidio.zidio_connect.repository.ChatMessageRepository;
import com.zidio.zidio_connect.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @GetMapping("/chat/{userId1}/{userId2}")
    public List<ChatMessage> getChatMessages(
            @PathVariable Long userId1,
            @PathVariable Long userId2) {
        return chatMessageRepository.findChatBetweenUsers(userId1, userId2);
    }
    @GetMapping("/sent/{senderId}")
    public ResponseEntity<List<ChatMessage>> getSentMessages(@PathVariable Long senderId) {
        return ResponseEntity.ok(chatService.getMessagesBySender(senderId));
    }

    @GetMapping("/received/{recipientId}")
    public ResponseEntity<List<ChatMessage>> getReceivedMessages(@PathVariable Long recipientId) {
        return ResponseEntity.ok(chatService.getMessagesByRecipient(recipientId));
    }

    @PostMapping("/send")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessage message) {
        return ResponseEntity.ok(chatService.sendMessage(message));
    }
}
