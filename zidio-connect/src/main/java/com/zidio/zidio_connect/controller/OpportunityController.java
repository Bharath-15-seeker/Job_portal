package com.zidio.zidio_connect.controller;

import com.zidio.zidio_connect.model.Opportunity;
import com.zidio.zidio_connect.service.OpportunityService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    @PostMapping("/post")
    public ResponseEntity<?> postOpportunity(@RequestBody Opportunity opp) {
        return ResponseEntity.ok(opportunityService.postOpportunity(opp));
    }

    @GetMapping("/recruiter/{recruiterId}")
    public ResponseEntity<?> getByRecruiter(@PathVariable Long recruiterId) {
        return ResponseEntity.ok(opportunityService.getByRecruiterId(recruiterId));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(opportunityService.searchByTitle(title));
    }
}

