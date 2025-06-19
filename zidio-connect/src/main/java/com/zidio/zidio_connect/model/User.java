package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "postedBy",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    private List<Opportunity> opportunities;


    @OneToOne(mappedBy = "user",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    private StudentProfile studentProfile;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role; // STUDENT, RECRUITER, ADMIN

    private boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime lastLogin;

}

