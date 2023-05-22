package com.ericsson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecuityHistoryJPA extends JpaRepository<com.ericsson.entity.SecurityHistory, Long> {
}
