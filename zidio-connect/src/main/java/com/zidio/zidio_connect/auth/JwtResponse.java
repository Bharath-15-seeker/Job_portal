package com.zidio.zidio_connect.auth;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String email;
}

