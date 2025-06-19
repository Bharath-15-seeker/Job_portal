package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    List<Opportunity> findByTitleContainingIgnoreCase(String title);
    List<Opportunity> findByPostedById(Long recruiterId);

    void deleteByPostedBy_Id(Long id);
}
