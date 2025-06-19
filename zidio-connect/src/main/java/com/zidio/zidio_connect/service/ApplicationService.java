package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.dto.ApplicationApplyRequest;
import com.zidio.zidio_connect.dto.ApplicationResponseDTO;
import com.zidio.zidio_connect.model.Application;
import com.zidio.zidio_connect.model.Opportunity;
import com.zidio.zidio_connect.model.User;
import com.zidio.zidio_connect.repository.ApplicationRepository;
import com.zidio.zidio_connect.repository.OpportunityRepository;
import com.zidio.zidio_connect.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationService {

    public ApplicationService(ApplicationRepository applicationRepo, UserRepository userRepo, OpportunityRepository oppRepo, ApplicationRepository appRepo) {
        this.applicationRepo = applicationRepo;
        this.userRepo = userRepo;
        this.oppRepo = oppRepo;
        this.appRepo = appRepo;
    }
    private final ApplicationRepository applicationRepo;
    private final UserRepository userRepo;
    private final OpportunityRepository oppRepo;
    private final ApplicationRepository appRepo;


    public List<Application> getByStudentId(Long studentId) {
        return applicationRepo.findByStudentId(studentId);
    }

    public List<Application> getByOpportunityId(Long opportunityId) {
        return applicationRepo.findByOpportunityId(opportunityId);
    }

    @Transactional
    public ApplicationResponseDTO apply(@Valid ApplicationApplyRequest dto) {

        User student = userRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        Opportunity opp = oppRepo.findById(dto.getOpportunityId())
                .orElseThrow(() -> new IllegalArgumentException("Opportunity not found"));

        Application app = new Application();
        app.setStudent(student);
        app.setOpportunity(opp);
        app.setStatus(dto.getStatus() != null ? dto.getStatus() : "APPLIED");
        app.setAppliedAt(dto.getAppliedAt() != null ? dto.getAppliedAt() : LocalDate.now());

        Application saved = appRepo.save(app);

        // map to response
        ApplicationResponseDTO resp = new ApplicationResponseDTO();
        resp.setId(saved.getId());
        resp.setStudentId(saved.getStudent().getId());
        resp.setOpportunityId(saved.getOpportunity().getId());
        resp.setStatus(saved.getStatus());
        resp.setAppliedAt(saved.getAppliedAt());
        return resp;
    }
}
