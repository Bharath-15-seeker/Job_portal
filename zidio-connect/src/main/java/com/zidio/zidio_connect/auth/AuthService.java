package com.zidio.zidio_connect.auth;

import com.zidio.zidio_connect.dto.UserRequest;
import com.zidio.zidio_connect.dto.UserResponse;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    public UserResponse register(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());

        User saved = userRepository.save(user);

        UserResponse response = new UserResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setRole(saved.getRole());
        response.setActive(saved.isActive());
        response.setCreatedAt(saved.getCreatedAt());
        response.setLastLogin(saved.getLastLogin());

        return response;
    }


    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!new BCryptPasswordEncoder().matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
