package com.zidio.zidio_connect.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileRequest {
    @NotNull(message = "User ID is required")
    private Long userId;

    private String university;
    private String degree;
    private int yearOfStudy;
    private String resumeUrl;


}