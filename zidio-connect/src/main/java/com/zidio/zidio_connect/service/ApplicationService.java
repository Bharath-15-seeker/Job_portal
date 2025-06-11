package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.Application;
import com.zidio.zidio_connect.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepo;

    public List<Application> getByStudentId(Long studentId) {
        return applicationRepo.findByStudentId(studentId);
    }

    public List<Application> getByOpportunityId(Long opportunityId) {
        return applicationRepo.findByOpportunityId(opportunityId);
    }

    public Application apply(Application application) {
        return applicationRepo.save(application);
    }
}
