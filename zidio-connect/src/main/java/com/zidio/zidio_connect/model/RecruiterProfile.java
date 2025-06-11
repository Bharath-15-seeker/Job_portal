package com.zidio.zidio_connect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterProfile {

    @Id
    private Long userId;

    @OneToOne
    @MapsId
    private User user;

    private String companyName;

    private String designation;

    private String companyWebsite;
}