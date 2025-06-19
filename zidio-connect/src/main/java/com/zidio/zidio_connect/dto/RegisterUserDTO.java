package com.zidio.zidio_connect.dto;

import jakarta.validation.constraints.*;

public record RegisterUserDTO(
        @NotBlank String username,
        @Email String email,
        @Size(min = 8) String password,
        @Pattern(regexp = "EMPLOYER|APPLICANT") String role  // Enum validation
) {}