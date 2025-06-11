package com.zidio.zidio_connect.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.zidio_connect.auth.JwtRequest;
import com.zidio.zidio_connect.auth.JwtResponse;
import com.zidio.zidio_connect.auth.RegisterRequest;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.UserRepository;
import com.zidio.zidio_connect.auth.JwtUtil;
import com.zidio.zidio_connect.service.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole()); // e.g., STUDENT or RECRUITER

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}

