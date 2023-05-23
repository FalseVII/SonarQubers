package com.ericsson.service;


import com.ericsson.entity.Hotspot;
import com.ericsson.entity.HotspotResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

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

    public String getSecurityReviewRating() throws Exception {
        String apiUrl = "http://localhost:9000/api/measures/component?component=vuln_project&metricKeys=security_review_rating";
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Bearer squ_4d75bfdf908f2b1377e2e4ee86ae18777b4b9fac");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error Code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        JsonReader jsonReader = Json.createReader(br);
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        conn.disconnect();


        JsonObject component = jsonObject.getJsonObject("component");
        JsonArray measures = component.getJsonArray("measures");
        JsonObject measureObject = measures.getJsonObject(0);  // assuming there's at least one measure

        String securityReviewRating = measureObject.getString("value");

        return securityReviewRating;
    }
}