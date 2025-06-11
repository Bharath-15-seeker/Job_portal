package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.UploadHistory;
import com.zidio.zidio_connect.repository.UploadHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UploadHistoryService {

    @Autowired
    private UploadHistoryRepository uploadHistoryRepository;

    public UploadHistory saveUploadHistory(UploadHistory uploadHistory) {
        uploadHistory.setUploadedAt(LocalDateTime.now());
        return uploadHistoryRepository.save(uploadHistory);
    }

    public List<UploadHistory> getUploadsByUser(Long userId) {
        return uploadHistoryRepository.findByUserId(userId);
    }
}
