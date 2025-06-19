package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "posted_by_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User postedBy; // Recruiter

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String type; // JOB or INTERNSHIP

    private String location;

    private boolean remote;

    private LocalDate startDate;

    private int durationWeeks;

    private double stipend;

    private LocalDate postedAt;
}
