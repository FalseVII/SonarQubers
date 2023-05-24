package com.ericsson.service;

import com.ericsson.entity.Hotspot;
import com.ericsson.entity.SecurityHistory;
import com.ericsson.repository.SecuityHistoryJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotspotClassifierTest {

    @Mock
    private SonarQubeService sonarQubeService;

    @Mock
    private SecuityHistoryJPA secuityHistoryJPA;

    private HotspotClassifier hotspotClassifier;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        hotspotClassifier = new HotspotClassifier();
    }

    @Test
    public void testClassify() {
        // Mock SonarQubeService.getIssues() to return a list of sample hotspots
        List<Hotspot> sampleHotspots = createSampleHotspots();
        when(sonarQubeService.getIssues()).thenReturn(sampleHotspots);

        // Call the classify method
        hotspotClassifier.classify();

        // Verify the calls to secuityHistoryJPA.save()
        verify(secuityHistoryJPA, times(1)).save(any(SecurityHistory.class));

        // Assert the generated SecurityHistory object
        SecurityHistory savedSecurityHistory = hotspotClassifier.getSecurityHistory();
        assertEquals(LocalDateTime.now().toString(), savedSecurityHistory.getDatetime().toString());
        assertEquals("Test", savedSecurityHistory.getProj_name());
        assertEquals("1", savedSecurityHistory.getOwasp1_count());
        assertEquals("2", savedSecurityHistory.getOwasp2_count());
        assertEquals("3", savedSecurityHistory.getOwasp3_count());
        assertEquals("4", savedSecurityHistory.getOwasp4_count());
        assertEquals("5", savedSecurityHistory.getOwasp5_count());
        assertEquals("6", savedSecurityHistory.getOwasp6_count());
        assertEquals("7", savedSecurityHistory.getOwasp7_count());
        assertEquals("8", savedSecurityHistory.getOwasp8_count());
        assertEquals("9", savedSecurityHistory.getOwasp9_count());
        assertEquals("0", savedSecurityHistory.getOwasp10_count());
        assertEquals("0", savedSecurityHistory.getCest_count());
        assertEquals("0", savedSecurityHistory.getCwe_count());
    }

    private List<Hotspot> createSampleHotspots() {
        List<Hotspot> hotspots = new ArrayList<>();

        // Create sample hotspots and add them to the list
        for (int i = 0; i < 9; i++) {
            Hotspot hotspot = new Hotspot();
            hotspots.add(hotspot);
        }

        return hotspots;
    }
}







