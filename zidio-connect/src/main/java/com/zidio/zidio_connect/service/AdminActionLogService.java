package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.AdminActionLog;
import com.zidio.zidio_connect.model.Opportunity;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminActionLogService {

    @Autowired
    private AdminActionLogRepository adminActionLogRepository;

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private OpportunityRepository oppRepo;
    @Autowired
    private RecruiterProfileRepository recruiterProfileRepo;
    @Autowired
    private StudentProfileRepository studentProfileRepo;
    @Autowired
    private ApplicationRepository applicationRepo;
    @Autowired
    private ChatMessageRepository chatRepo;


    public AdminActionLog logAction(AdminActionLog actionLog) {
        actionLog.setTimestamp(LocalDateTime.now());
        return adminActionLogRepository.save(actionLog);
    }

    @Transactional
    public void deleteUser(Long id, String adminEmail) {

        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        User admin = userRepo.findByEmail(adminEmail)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));


        chatRepo.deleteMessagesByUser(id);

        applicationRepo.deleteByStudentId(id);
        applicationRepo.deleteByOpportunityPostedBy_id(id);
        oppRepo.deleteByPostedBy_Id(id);
        studentProfileRepo.deleteByUserId(id);
        userRepo.delete(user);


        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            throw new IllegalStateException("Cannot delete another admin account");
        }


        adminActionLogRepository.save(
                AdminActionLog.builder()
                        .admin(admin)                       // FK to admin
                        .actionType("DELETE_USER")
                        .target(user.getEmail())
                        .description("Admin deleted user id=" + id)
                        .build()
        );
    }

    /** Convenience wrapper for recruiter‑only delete */
    public void deleteRecruiter(Long recruiterId, String adminEmail) {
        deleteUser(recruiterId, adminEmail);  // same logic
    }
    public List<AdminActionLog> getAllLogs() {
        return adminActionLogRepository.findAll();
    }


    public List<AdminActionLog> getLogsByAdmin(Long adminId) {
        return adminActionLogRepository.findByAdminId(adminId);
    }
}
