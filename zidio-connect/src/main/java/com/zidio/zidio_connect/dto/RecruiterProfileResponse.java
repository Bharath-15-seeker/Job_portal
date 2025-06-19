package com.zidio.zidio_connect.dto;

import lombok.Data;

@Data
public class RecruiterProfileResponse {
    private Long id;             // ok to expose
    private Long userId;
    private String companyName;
    private String designation;
    private String companyWebsite;
    private Integer version;      // expose if you want optimistic‑lock info
}