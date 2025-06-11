package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.AdminActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminActionLogRepository extends JpaRepository<AdminActionLog, Long> {
    List<AdminActionLog> findByAdminId(Long adminId);
}
