package com.ericsson.service;

import com.ericsson.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueClassifier {

    @Autowired
    private com.ericsson.entity.IssuesResponse issuesResponse;

    @Autowired
    private com.ericsson.entity.Issue issue;

    @Autowired
    private com.ericsson.service.SonarQubeService sonarQubeService;

    public List<Issue> classify() {
        List<Issue> classified = new ArrayList<>();
        for (com.ericsson.entity.Issue issue : sonarQubeService.getIssues()) {
            if (issue.getTags().contains("cwe")) {
                System.out.println("Issue key: " + issue.getKey());
                System.out.println("Issue rule: " + issue.getRule());
                classified.add(issue);
            }
        }
        return classified;
    }


}
