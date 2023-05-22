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

    @GetMapping(value = "/get")
    public String get() {
        List<Issue> issues = issueClassifier.classify();
        return issues.toString();
    }
}
