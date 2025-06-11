package com.zidio.zidio_connect.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterProfileDTO {
    private Long userId;
    private String companyName;

    private String designation;

    private String companyWebsite;
}
