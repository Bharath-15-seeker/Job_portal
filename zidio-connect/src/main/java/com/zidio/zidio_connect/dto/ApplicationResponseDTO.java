package com.zidio.zidio_connect.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationResponseDTO {

    private Long id;

    private Long studentId;
    private Long opportunityId;

    private String status;
    private LocalDate appliedAt;
}
