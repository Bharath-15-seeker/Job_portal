package com.zidio.zidio_connect.auth;

import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(new BCryptPasswordEncoder().encode(request.password));
        user.setRole(request.role);
        user.setActive(true);
        user.setCreatedAt(java.time.LocalDateTime.now());

        userRepository.save(user);
        return "User registered successfully";
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
