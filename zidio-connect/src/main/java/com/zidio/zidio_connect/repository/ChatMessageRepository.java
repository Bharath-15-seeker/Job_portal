package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.ChatMessage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndRecipientId(Long senderId, Long recipientId);

    List<ChatMessage> findByRecipientId(Long recipientId);

    List<ChatMessage> findBySenderId(Long senderId);
    @Query("SELECT m FROM ChatMessage m WHERE " +
            "(m.sender.id = :userId1 AND m.recipient.id = :userId2) OR " +
            "(m.sender.id = :userId2 AND m.recipient.id = :userId1) " +
            "ORDER BY m.sentAt ASC")
    List<ChatMessage> findChatBetweenUsers(@Param("userId1") Long userId1,
                                           @Param("userId2") Long userId2);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
    DELETE FROM ChatMessage m
    WHERE m.sender.id = :userId
       OR m.recipient.id = :userId
    """)
    void deleteMessagesByUser(@Param("userId")Long id);
}
