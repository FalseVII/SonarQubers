package com.ericsson.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "security_history")
public class SecurityHistory {
    @Id
    private Long id;

    private String proj_name;

    private String datetime;

    private String owasp1_count;

    private String owasp2_count;

    private String owasp3_count;

    private String owasp4_count;

    private String owasp5_count;

    private String owasp6_count;

    private String owasp7_count;

    private String owasp8_count;

    private String owasp9_count;

    private String owasp10_count;

    private String cest_count;

    private String cwe_count;




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
