
package com.zidio.zidio_connect.repository;

import com.zidio.zidio_connect.model.Application;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByStudentId(Long studentId);
    List<Application> findByOpportunityId(Long opportunityId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("DELETE FROM Application a WHERE a.student.id = :studentId")
    void deleteByStudentId(@Param("studentId")Long id);

    void deleteByOpportunityPostedBy_id(Long id);
}
