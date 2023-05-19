package com.ericsson.entity;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ratings")
public class SecuritySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String projectKey;
    private String summary;

    public void setProjectKey(String sonarqubeProjectKey) {
    }

    public void setSummary(String owaspSummary) {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public String getSummary() {
        return summary;
    }
}
