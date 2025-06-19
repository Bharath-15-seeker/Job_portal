package com.zidio.zidio_connect.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecruiterProfileRequest {
    @NotNull  private Long userId;
    @NotBlank private String companyName;
    @NotBlank private String designation;
    @NotBlank private String companyWebsite;
}
