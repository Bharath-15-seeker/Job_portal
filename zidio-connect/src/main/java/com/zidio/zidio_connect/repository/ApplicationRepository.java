
package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByStudentId(Long studentId);
    List<Application> findByOpportunityId(Long opportunityId);
}
