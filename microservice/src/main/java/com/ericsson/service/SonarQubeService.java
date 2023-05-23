package com.ericsson.service;


import com.ericsson.entity.Hotspot;
import com.ericsson.entity.HotspotResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

@Service
public class SonarQubeService {
    private RestTemplate restTemplate = new RestTemplate();

    public List<Hotspot> getIssues() {
        RestTemplate restTemplate = new RestTemplate();

        //add header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer squ_4d75bfdf908f2b1377e2e4ee86ae18777b4b9fac" );

        String apiUrl = "http://localhost:9000/api/hotspots/search?projectKey=vuln_project&owaspTop10=a1,a2,a3,a4,a5,a6,a7,a8,a9,a10";

        // You can add parameters to your URL if needed

        //add headers
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // Send the request as GET

        ResponseEntity<HotspotResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, HotspotResponse.class);

        // Extract the hotspots from the response
        List<Hotspot> hotspots = response.getBody().getHotspots();

        return hotspots;
    }
}