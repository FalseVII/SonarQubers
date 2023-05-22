package com.ericsson.entity;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassifiedIssues {

    List<Issue> owaspa1;
    List<Issue> owaspa2;
    List<Issue> owaspa3;
    List<Issue> owaspa4;
    List<Issue> owaspa5;
    List<Issue> owaspa6;
    List<Issue> owaspa7;
    List<Issue> owaspa8;
    List<Issue> owaspa9;
    List<Issue> owaspa10;
    List<Issue> cest;
    List<Issue> cwe;

    public List<Issue> getOwaspa1() {
        return owaspa1;
    }

    public void setOwaspa1(List<Issue> owaspa1) {
        this.owaspa1 = owaspa1;
    }

    public List<Issue> getOwaspa2() {
        return owaspa2;
    }

    public void setOwaspa2(List<Issue> owaspa2) {
        this.owaspa2 = owaspa2;
    }

    public List<Issue> getOwaspa3() {
        return owaspa3;
    }

    public void setOwaspa3(List<Issue> owaspa3) {
        this.owaspa3 = owaspa3;
    }

    public List<Issue> getOwaspa4() {
        return owaspa4;
    }

    public void setOwaspa4(List<Issue> owaspa4) {
        this.owaspa4 = owaspa4;
    }

    public List<Issue> getOwaspa5() {
        return owaspa5;
    }

    public void setOwaspa5(List<Issue> owaspa5) {
        this.owaspa5 = owaspa5;
    }

    public List<Issue> getOwaspa6() {
        return owaspa6;
    }

    public void setOwaspa6(List<Issue> owaspa6) {
        this.owaspa6 = owaspa6;
    }

    public List<Issue> getOwaspa7() {
        return owaspa7;
    }

    public void setOwaspa7(List<Issue> owaspa7) {
        this.owaspa7 = owaspa7;
    }

    public List<Issue> getOwaspa8() {
        return owaspa8;
    }

    public void setOwaspa8(List<Issue> owaspa8) {
        this.owaspa8 = owaspa8;
    }

    public List<Issue> getOwaspa9() {
        return owaspa9;
    }

    public void setOwaspa9(List<Issue> owaspa9) {
        this.owaspa9 = owaspa9;
    }

    public List<Issue> getOwaspa10() {
        return owaspa10;
    }

    public void setOwaspa10(List<Issue> owaspa10) {
        this.owaspa10 = owaspa10;
    }

    public List<Issue> getCest() {
        return cest;
    }

    public void setCest(List<Issue> cest) {
        this.cest = cest;
    }

    public List<Issue> getCwe() {
        return cwe;
    }

    public void setCwe(List<Issue> cwe) {
        this.cwe = cwe;
    }
}
