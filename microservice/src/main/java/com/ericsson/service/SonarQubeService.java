package com.ericsson.service;


import com.ericsson.entity.Issue;
import com.ericsson.entity.IssuesResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

@Service
public class SonarQubeService {
    private RestTemplate restTemplate = new RestTemplate();

    public List<Issue> getIssues() {
        final String uri = "http://localhost:9000/api/issues/search?componentKeys=vuln_project";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer squ_6cbb1583369b6964f49f60d705eb989ddd678fdb");
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<IssuesResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, IssuesResponse.class);
        return response.getBody().getIssues();
    }
}