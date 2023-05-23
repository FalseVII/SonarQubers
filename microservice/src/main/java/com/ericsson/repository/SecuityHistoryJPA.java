package com.ericsson.repository;

import com.ericsson.entity.SecurityHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecuityHistoryJPA extends JpaRepository<com.ericsson.entity.SecurityHistory, Long> {

   List<SecurityHistory> findTop5ByOrderByDatetimeDesc();
}
