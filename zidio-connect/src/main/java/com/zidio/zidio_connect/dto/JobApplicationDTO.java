package com.zidio.zidio_connect.dto;

import jakarta.validation.constraints.*;

public record JobApplicationDTO(
        @NotNull Long jobId,
        @NotNull Long applicantId,
        @NotBlank String coverLetter
) {}
