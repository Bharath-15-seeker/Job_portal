package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
