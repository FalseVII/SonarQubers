package com.ericsson.controller;

import com.ericsson.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    private com.ericsson.service.SonarQubeService sonarQubeService;

    @Autowired
    private com.ericsson.entity.IssuesResponse issuesResponse;

    @Autowired
    private com.ericsson.entity.Issue issue;

    @Autowired
    private com.ericsson.service.IssueClassifier issueClassifier;

    @Autowired
    private com.ericsson.entity.ClassifiedIssues classifiedIssues;



    @PostMapping(value = "/classify")
    public void classify() {
        issueClassifier.classify();
    }

    @GetMapping(value = "/api/v1/owasp1")
    public List<Issue> getOwasp1() {
        return classifiedIssues.getOwaspa1();
    }

    @GetMapping(value = "/api/v1/owasp2")
    public List<Issue> getOwasp2() {
        return classifiedIssues.getOwaspa2();
    }

    @GetMapping(value = "/api/v1/owasp3")
    public List<Issue> getOwasp3() {
        return classifiedIssues.getOwaspa3();
    }

    @GetMapping(value = "/api/v1/owasp4")
    public List<Issue> getOwasp4() {
        return classifiedIssues.getOwaspa4();
    }

    @GetMapping(value = "/api/v1/owasp5")
    public List<Issue> getOwasp5() {
        return classifiedIssues.getOwaspa5();
    }

    @GetMapping(value = "/api/v1/owasp6")
    public List<Issue> getOwasp6() {
        return classifiedIssues.getOwaspa6();
    }

    @GetMapping(value = "/api/v1/owasp7")
    public List<Issue> getOwasp7() {
        return classifiedIssues.getOwaspa7();
    }

    @GetMapping(value = "/api/v1/owasp8")
    public List<Issue> getOwasp8() {
        return classifiedIssues.getOwaspa8();
    }

    @GetMapping(value = "/api/v1/owasp9")
    public List<Issue> getOwasp9() {
        return classifiedIssues.getOwaspa9();
    }

    @GetMapping(value = "/api/v1/owasp10")
    public List<Issue> getOwasp10() {
        return classifiedIssues.getOwaspa10();
    }

    @GetMapping(value = "/api/v1/cest")
    public List<Issue> getCest() {
        return classifiedIssues.getCest();
    }

    @GetMapping(value = "/api/v1/cwe")
    public List<Issue> getCwe() {
        return classifiedIssues.getCwe();
    }

    @GetMapping(value = "/api/v1/all")
    public List<Issue> getAll() {
        return issuesResponse.getIssues();
    }
}
