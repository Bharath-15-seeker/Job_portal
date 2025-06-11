package com.zidio.zidio_connect.dto;

import com.zidio.zidio_connect.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String role;

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

}
