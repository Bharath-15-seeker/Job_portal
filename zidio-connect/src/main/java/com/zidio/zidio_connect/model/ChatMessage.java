package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User recipient;

    private String content;

    private LocalDateTime sentAt;

    private boolean isRead;

    // Getters and Setters
}
