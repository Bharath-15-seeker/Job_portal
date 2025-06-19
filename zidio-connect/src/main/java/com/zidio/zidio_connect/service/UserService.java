package com.zidio.zidio_connect.service;


import com.zidio.zidio_connect.dto.UserRequest;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserRequest getCurrentUser(UserDetails userDetails) {
        // You can already access email from userDetails.getUsername()
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserRequest(user);
    }

}
