package com.zidio.zidio_connect.auth;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    private String email;
    private String password;
}
