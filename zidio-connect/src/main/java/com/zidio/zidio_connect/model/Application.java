package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Opportunity opportunity;

    private String status; // APPLIED, SHORTLISTED, REJECTED

    private LocalDate appliedAt;
}
