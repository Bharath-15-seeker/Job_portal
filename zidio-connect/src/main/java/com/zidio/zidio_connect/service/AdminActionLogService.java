package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.AdminActionLog;
import com.zidio.zidio_connect.repository.AdminActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminActionLogService {

    @Autowired
    private AdminActionLogRepository adminActionLogRepository;

    public AdminActionLog logAction(AdminActionLog actionLog) {
        actionLog.setTimestamp(LocalDateTime.now());
        return adminActionLogRepository.save(actionLog);
    }

    public List<AdminActionLog> getAllLogs() {
        return adminActionLogRepository.findAll();
    }

    public List<AdminActionLog> getLogsByAdmin(Long adminId) {
        return adminActionLogRepository.findByAdminId(adminId);
    }
}
