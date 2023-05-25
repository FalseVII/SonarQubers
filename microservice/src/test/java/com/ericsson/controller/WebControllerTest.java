package com.ericsson.controller;

import com.ericsson.entity.Hotspot;
import com.ericsson.entity.SecurityHistory;
import com.ericsson.service.HotspotClassifier;
import com.ericsson.service.SonarQubeService;
import com.ericsson.entity.ClassifiedHotspots;
import com.ericsson.repository.SecuityHistoryJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;


import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SonarQubeService sonarQubeService;

    @MockBean
    private ClassifiedHotspots classifiedHotspots;

    @MockBean
    private SecuityHistoryJPA secuityHistoryJPA;

    @MockBean
    private HotspotClassifier hotspotClassifier;

    private List<Hotspot> hotspotList;
    private List<SecurityHistory> securityHistoryList;

    @BeforeEach
    public void setup() {
        // Mock data setup
        hotspotList = Collections.singletonList(new Hotspot());
        securityHistoryList = Collections.singletonList(new SecurityHistory());
    }

    @Test
    public void testGetOwasp1() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"key\":null,\"component\":null,\"project\":null,\"securityCategory\":null,\"vulnerabilityProbability\":null,\"status\":null,\"line\":0,\"message\":null,\"author\":null,\"creationDate\":null,\"updateDate\":null,\"textRange\":null,\"flows\":null,\"ruleKey\":null}]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp2() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp2"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp3() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp3"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp4() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp4"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp5() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp5"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp6() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp6"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp7() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp7"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp8() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp8"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp9() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp9"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }

    @Test
    public void testGetOwasp10() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/owasp10"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // expected to return list of Hotspots in JSON format
    }


    @Test
    public void testGetOwaspAll() throws Exception {
        when(classifiedHotspots.getOwaspa1()).thenReturn(hotspotList);

        mockMvc.perform(get("/api/v1/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("")); // expected to return list of Hotspots in JSON format
    }


    @Test
    public void testClassify() throws Exception {
        mockMvc.perform(post("/classify"))
                .andExpect(status().isOk());

        verify(hotspotClassifier, times(1)).classify();
    }

    @Test
    public void testGetRating() throws Exception {
        String expectedRating = "5.0";
        when(sonarQubeService.getSecurityReviewRating()).thenReturn(expectedRating);

        mockMvc.perform(get("/api/v1/rating"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedRating));
    }

    @Test
    public void testGetLastFive() throws Exception {
        when(secuityHistoryJPA.findTop5ByOrderByDatetimeDesc()).thenReturn(securityHistoryList);

        mockMvc.perform(get("/api/v1/repo"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":null,\"proj_name\":null,\"datetime\":null,\"owasp1_count\":null,\"owasp2_count\":null,\"owasp3_count\":null,\"owasp4_count\":null,\"owasp5_count\":null,\"owasp6_count\":null,\"owasp7_count\":null,\"owasp8_count\":null,\"owasp9_count\":null,\"owasp10_count\":null,\"cest_count\":null,\"cwe_count\":null}]")); // expected to return list of SecurityHistory in JSON format
    }
}