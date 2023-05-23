package com.ericsson.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "security_history")
public class SecurityHistory {
    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "proj_name", nullable = false)
    private String proj_name;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @Column(name = "owasp1_count", nullable = false)
    private String owasp1_count;

    @Column(name = "owasp2_count", nullable = false)
    private String owasp2_count;

    @Column(name = "owasp3_count", nullable = false)
    private String owasp3_count;

    @Column(name = "owasp4_count", nullable = false)
    private String owasp4_count;

    @Column(name = "owasp5_count", nullable = false)
    private String owasp5_count;

    @Column(name = "owasp6_count", nullable = false)
    private String owasp6_count;

    @Column(name = "owasp7_count", nullable = false)
    private String owasp7_count;

    @Column(name = "owasp8_count", nullable = false)
    private String owasp8_count;

    @Column(name = "owasp9_count", nullable = false)
    private String owasp9_count;

    @Column(name = "owasp10_count", nullable = false)
    private String owasp10_count;

    @Column(name = "cest_count", nullable = false)
    private String cest_count;

    @Column(name = "cwe_count", nullable = false)
    private String cwe_count;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getProj_name() {
        return proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getOwasp1_count() {
        return owasp1_count;
    }

    public void setOwasp1_count(String owasp1_count) {
        this.owasp1_count = owasp1_count;
    }

    public String getOwasp2_count() {
        return owasp2_count;
    }

    public void setOwasp2_count(String owasp2_count) {
        this.owasp2_count = owasp2_count;
    }

    public String getOwasp3_count() {
        return owasp3_count;
    }

    public void setOwasp3_count(String owasp3_count) {
        this.owasp3_count = owasp3_count;
    }

    public String getOwasp4_count() {
        return owasp4_count;
    }

    public void setOwasp4_count(String owasp4_count) {
        this.owasp4_count = owasp4_count;
    }

    public String getOwasp5_count() {
        return owasp5_count;
    }

    public void setOwasp5_count(String owasp5_count) {
        this.owasp5_count = owasp5_count;
    }

    public String getOwasp6_count() {
        return owasp6_count;
    }

    public void setOwasp6_count(String owasp6_count) {
        this.owasp6_count = owasp6_count;
    }

    public String getOwasp7_count() {
        return owasp7_count;
    }

    public void setOwasp7_count(String owasp7_count) {
        this.owasp7_count = owasp7_count;
    }

    public String getOwasp8_count() {
        return owasp8_count;
    }

    public void setOwasp8_count(String owasp8_count) {
        this.owasp8_count = owasp8_count;
    }

    public String getOwasp9_count() {
        return owasp9_count;
    }

    public void setOwasp9_count(String owasp9_count) {
        this.owasp9_count = owasp9_count;
    }

    public String getOwasp10_count() {
        return owasp10_count;
    }

    public void setOwasp10_count(String owasp10_count) {
        this.owasp10_count = owasp10_count;
    }

    public String getCest_count() {
        return cest_count;
    }

    public void setCest_count(String cest_count) {
        this.cest_count = cest_count;
    }

    public String getCwe_count() {
        return cwe_count;
    }

    public void setCwe_count(String cwe_count) {
        this.cwe_count = cwe_count;
    }
}
