package com.zidio.zidio_connect.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * Payload to apply for an opportunity.
 * {
 *   "studentId": 1,
 *   "opportunityId": 3
 * }
 */
@Data
public class ApplicationApplyRequest {

    @NotNull
    private Long studentId;

    @NotNull
    private Long opportunityId;

    private String status;         // Optional: Defaults to "APPLIED"
    private LocalDate appliedAt;

}
