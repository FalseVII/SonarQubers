package com.ericsson.service;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class SonarQubeService {
    private RestTemplate restTemplate = new RestTemplate();

    public String getIssues() {
        final String uri = "http://localhost:9000/api/issues/search?componentKeys=vuln_project";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(uri, String.class);
        System.out.println(response);
        return "hello";
    }
}