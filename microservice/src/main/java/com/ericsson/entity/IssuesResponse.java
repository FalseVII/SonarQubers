package com.ericsson.entity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuesResponse {
    private List<Issue> issues;

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}