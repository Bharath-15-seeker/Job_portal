package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User recipient;

    private String message;

    private boolean isRead;

    private LocalDateTime timestamp;

    // Getters and Setters
}
