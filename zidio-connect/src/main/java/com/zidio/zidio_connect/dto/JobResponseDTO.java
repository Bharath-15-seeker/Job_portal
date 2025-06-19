package com.zidio.zidio_connect.dto;

public record JobResponseDTO(
        Long id,
        String title,
        String description,
        String location,
        double salary,
        String employerName  // Custom field (not in entity)
) {}