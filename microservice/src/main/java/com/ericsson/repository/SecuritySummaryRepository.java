package com.ericsson.repository;



import com.ericsson.entity.SecuritySummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecuritySummaryRepository extends JpaRepository<SecuritySummary, Long> {
}
