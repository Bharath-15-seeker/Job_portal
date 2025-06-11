package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.dto.StudentProfileRequest;
import com.zidio.zidio_connect.model.StudentProfile;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.StudentProfileRepository;
import com.zidio.zidio_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentProfileService {
    @Autowired
    private StudentProfileRepository studentRepo;


    @Autowired
    private  UserRepository userRepository;

    public StudentProfile createStudentProfile(StudentProfileRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getUserId()));

        StudentProfile profile = StudentProfile.builder()
                .user(user)
                .university(request.getUniversity())
                .degree(request.getDegree())
                .yearOfStudy(request.getYearOfStudy())
                .resumeUrl(request.getResumeUrl())
                .build();

        return studentRepo.save(profile);
    }
    public Optional<StudentProfile> getByUserId(Long userId) {
        return studentRepo.findByUserId(userId);
    }

    public StudentProfile saveProfile(StudentProfile profile) {
        return studentRepo.save(profile);
    }
}
