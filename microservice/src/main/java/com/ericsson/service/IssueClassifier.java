package com.ericsson.service;

import com.ericsson.entity.ClassifiedIssues;
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

    @Autowired
    private com.ericsson.entity.ClassifiedIssues classifiedIssues;

    public void classify() {
        List<Issue> owaspa1 = new ArrayList<>();
        List<Issue> owaspa2 = new ArrayList<>();
        List<Issue> owaspa3 = new ArrayList<>();
        List<Issue> owaspa4 = new ArrayList<>();
        List<Issue> owaspa5 = new ArrayList<>();
        List<Issue> owaspa6 = new ArrayList<>();
        List<Issue> owaspa7 = new ArrayList<>();
        List<Issue> owaspa8 = new ArrayList<>();
        List<Issue> owaspa9 = new ArrayList<>();
        List<Issue> owaspa10 = new ArrayList<>();
        List<Issue> cest = new ArrayList<>();
        List<Issue> cwe = new ArrayList<>();
        for (com.ericsson.entity.Issue issue : sonarQubeService.getIssues()) {
            if (issue.getTags().contains("cwe")) {
                cwe.add(issue);
            }
            if (issue.getTags().contains("owasp-a1")
                    || issue.getRule().contains("java:S5804")
                    || issue.getRule().contains("java:S6350")
                    || issue.getRule().contains("java:S4502")) {
                owaspa1.add(issue);
            }
            if (issue.getTags().contains("owasp-a2")
                    || issue.getRule().contains("")) {
                owaspa2.add(issue);
            }
            if (issue.getTags().contains("owasp-a3")
                    || issue.getRule().contains("java:S6350")
                    || issue.getRule().contains("java:S5247")) {
                owaspa3.add(issue);
            }
            if (issue.getTags().contains("owasp-a4")
                    || issue.getRule().contains("java:S5324")
                    || issue.getRule().contains("java:S6288")
                    || issue.getRule().contains("java:S5320")){
                owaspa4.add(issue);
            }
            if (issue.getTags().contains("owasp-a5")
                    || issue.getRule().contains("java:S5693")
                    || issue.getRule().contains("java:S3330")
                    || issue.getRule().contains("java:S4507")
                    || issue.getRule().contains("java:S5689"))
            {
                owaspa5.add(issue);
            }
            if (issue.getTags().contains("owasp-a6")) {
                owaspa6.add(issue);
            }
            if (issue.getTags().contains("owasp-a7")) {
                owaspa7.add(issue);
            }
            if (issue.getTags().contains("owasp-a8")
                    || issue.getRule().contains("java:S4434")) {
                owaspa8.add(issue);
            }
            if (issue.getTags().contains("owasp-a9")
                    || issue.getRule().contains("java:S4792")
            ){
                owaspa9.add(issue);
            }
            if (issue.getTags().contains("owasp-a10")
                    || issue.getRule().contains("java:S4792")) {
                owaspa10.add(issue);
            }
            if (issue.getTags().contains("cest")) {
                cest.add(issue);
            }
        }
        classifiedIssues.setOwaspa1(owaspa1);
        classifiedIssues.setOwaspa2(owaspa2);
        classifiedIssues.setOwaspa3(owaspa3);
        classifiedIssues.setOwaspa4(owaspa4);
        classifiedIssues.setOwaspa5(owaspa5);
        classifiedIssues.setOwaspa6(owaspa6);
        classifiedIssues.setOwaspa7(owaspa7);
        classifiedIssues.setOwaspa8(owaspa8);
        classifiedIssues.setOwaspa9(owaspa9);
        classifiedIssues.setOwaspa10(owaspa10);
        classifiedIssues.setCest(cest);
        classifiedIssues.setCwe(cwe);
        System.out.println("Classified issues");
    }
}
