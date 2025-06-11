package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UploadHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String fileName;

    private LocalDateTime uploadedAt;

    private String chartTypeGenerated; // 2D or 3D



    // Getters and Setters
}
