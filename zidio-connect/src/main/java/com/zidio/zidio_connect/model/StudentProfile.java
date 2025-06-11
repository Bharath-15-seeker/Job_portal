package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    private Long userId;

    @OneToOne
    @MapsId
    private User user;

    private String university;

    private String degree;

    private int yearOfStudy;

    private String resumeUrl;
}

