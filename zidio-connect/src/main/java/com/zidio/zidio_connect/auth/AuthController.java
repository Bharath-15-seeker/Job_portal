package com.zidio.zidio_connect.auth;

import com.zidio.zidio_connect.dto.UserRequest;
import com.zidio.zidio_connect.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.zidio_connect.repository.UserRepository;
import com.zidio.zidio_connect.service.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;

    private final AuthService userService ;


    // ✅ Login endpoint
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new JwtResponse(token, jwtRequest.getEmail()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // ✅ Register endpoint
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

}

