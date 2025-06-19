package com.zidio.zidio_connect.dto;

import com.zidio.zidio_connect.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String role; // e.g., STUDENT, RECRUITER, ADMIN


    public UserRequest(User user) {
        this.name=getName();
        this.email=getEmail();
        this.password=getPassword();
        this.role=getRole();
    }
}

