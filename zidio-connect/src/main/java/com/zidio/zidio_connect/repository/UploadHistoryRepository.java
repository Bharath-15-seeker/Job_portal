package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.UploadHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadHistoryRepository extends JpaRepository<UploadHistory, Long> {
    List<UploadHistory> findByUserId(Long userId);
}
