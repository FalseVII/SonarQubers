package com.ericsson.service;

import com.ericsson.entity.Hotspot;
import com.ericsson.entity.HotspotResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SonarQubeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SonarQubeService sonarQubeService;

    @Test
    public void testGetIssues() {
        // Prepare data for the test
        Hotspot hotspot = new Hotspot();
        HotspotResponse hotspotResponse = new HotspotResponse();
        hotspotResponse.setHotspots(Collections.singletonList(hotspot));

        ResponseEntity<HotspotResponse> responseEntity = ResponseEntity.ok(hotspotResponse);

        // Configure the mock to return our prepared data
        when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(), any(Class.class)))
                .thenReturn(responseEntity);

        // Call the method we're testing
        List<Hotspot> hotspots = sonarQubeService.getIssues();

        // Verify the results
        assertEquals(23, hotspots.size());

    }

    @Test
    public void testGetSecurityReviewRating() throws Exception {
        // Prepare data for the test
        String json = "{\"component\": {\"measures\": [{\"value\": \"5.0\"}]}}";

        InputStream inputStream = new ByteArrayInputStream(json.getBytes());
        HttpURLConnection connection = Mockito.mock(HttpURLConnection.class);
        when(connection.getResponseCode()).thenReturn(200);
        when(connection.getInputStream()).thenReturn(inputStream);

        URL url = Mockito.mock(URL.class);
        when(url.openConnection()).thenReturn(connection);

        // Configure the mock to return our prepared data
        when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(url);

        // Call the method we're testing
        String rating = sonarQubeService.getSecurityReviewRating();

        // Verify the results
        assertEquals("5.0", rating);
    }
}