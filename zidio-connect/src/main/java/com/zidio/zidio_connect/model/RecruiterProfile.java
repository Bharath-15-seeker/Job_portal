package com.zidio.zidio_connect.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruiter_profile")
@Data
public class RecruiterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String companyName;
    private String designation;
    private String companyWebsite;

    @Version                  // enables optimistic locking the right way
    private Integer version;
}
