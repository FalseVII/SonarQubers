package com.ericsson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private com.ericsson.service.SonarQubeService sonarQubeService;

    @GetMapping(value = "/get")
    public String get() {
        return sonarQubeService.getIssues();
    }
}
