package com.ericsson.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Issue {
    private String key;
    private String rule;
    private String severity;
    private String component;
    private String project;
    private int line;
    private String status;
    private String message;
    private List<String> tags;

    @Override
    public String toString() {
        return "Issue{" +
                "key='" + key + '\'' +
                ", rule='" + rule + '\'' +
                ", severity='" + severity + '\'' +
                ", component='" + component + '\'' +
                ", project='" + project + '\'' +
                ", line=" + line +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", tags=" + tags +
                '}';
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}