package com.ericsson.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Hotspot {
    private String key;
    private String component;
    private String project;
    private String securityCategory;
    private String vulnerabilityProbability;
    private String status;
    private int line;
    private String message;
    private String author;
    private String creationDate;
    private String updateDate;
    private TextRange textRange;
    private List<Flow> flows;
    private String ruleKey;

    // TODO: Add TextRange and Flow classes, or import if already defined

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getSecurityCategory() {
        return securityCategory;
    }

    public void setSecurityCategory(String securityCategory) {
        this.securityCategory = securityCategory;
    }

    public String getVulnerabilityProbability() {
        return vulnerabilityProbability;
    }

    public void setVulnerabilityProbability(String vulnerabilityProbability) {
        this.vulnerabilityProbability = vulnerabilityProbability;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public TextRange getTextRange() {
        return textRange;
    }

    public void setTextRange(TextRange textRange) {
        this.textRange = textRange;
    }

    public List<Flow> getFlows() {
        return flows;
    }

    public void setFlows(List<Flow> flows) {
        this.flows = flows;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }



    @Override
    public String toString() {
        return "Hotspot{" +
                "key='" + key + '\'' +
                ", component='" + component + '\'' +
                ", project='" + project + '\'' +
                ", securityCategory='" + securityCategory + '\'' +
                ", vulnerabilityProbability='" + vulnerabilityProbability + '\'' +
                ", status='" + status + '\'' +
                ", line=" + line +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", textRange=" + textRange +
                ", flows=" + flows +
                ", ruleKey='" + ruleKey + '\'' +
                '}';
    }
}

class TextRange {
    private int startLine;
    private int endLine;
    private int startOffset;
    private int endOffset;

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(int startOffset) {
        this.startOffset = startOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(int endOffset) {
        this.endOffset = endOffset;
    }

    @Override
    public String toString() {
        return "TextRange{" +
                "startLine=" + startLine +
                ", endLine=" + endLine +
                ", startOffset=" + startOffset +
                ", endOffset=" + endOffset +
                '}';
    }
}

class Flow {
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "locations=" + locations +
                '}';
    }
}

class Location {
    private String component;
    private TextRange textRange;
    private String msg;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public TextRange getTextRange() {
        return textRange;
    }

    public void setTextRange(TextRange textRange) {
        this.textRange = textRange;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Location{" +
                "component='" + component + '\'' +
                ", textRange=" + textRange +
                ", msg='" + msg + '\'' +
                '}';
    }


}