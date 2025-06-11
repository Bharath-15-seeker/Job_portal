package com.zidio.zidio_connect.service;

import com.zidio.zidio_connect.model.Opportunity;
import com.zidio.zidio_connect.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepo;

    public List<Opportunity> searchByTitle(String title) {
        return opportunityRepo.findByTitleContainingIgnoreCase(title);
    }

    public List<Opportunity> getByRecruiterId(Long recruiterId) {
        return opportunityRepo.findByPostedById(recruiterId);
    }

    public Opportunity postOpportunity(Opportunity opp) {
        return opportunityRepo.save(opp);
    }
}
