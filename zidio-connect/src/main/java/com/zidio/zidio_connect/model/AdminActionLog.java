package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class AdminActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User admin;

    private String actionType;  // e.g., BLOCK_USER, DELETE_JOB

    private String target;

    private String description;

    private LocalDateTime timestamp;

    // Getters and Setters
}
