package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.dto.UserDTO;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public UserDTO getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getCurrentUser(userDetails);
    }



    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
