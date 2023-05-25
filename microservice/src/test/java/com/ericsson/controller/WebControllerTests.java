package com.ericsson.controller;

import com.ericsson.entity.ClassifiedHotspots;
import com.ericsson.entity.Hotspot;
import com.ericsson.entity.HotspotResponse;
import com.ericsson.entity.SecurityHistory;
import com.ericsson.service.HotspotClassifier;
import com.ericsson.service.SonarQubeService;
import com.ericsson.repository.SecuityHistoryJPA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WebControllTest_Seperate {

    @Mock
    private SonarQubeService sonarQubeService;

    @Mock
    private ClassifiedHotspots classifiedHotspots;

    @Mock
    private HotspotClassifier hotspotClassifier;

    @Mock
    private HotspotResponse hotspotResponse;

    @Mock
    private SecuityHistoryJPA secuityHistoryJPA;

    @Mock
    private SecuityHistoryJPA securityHistoryJPA;

    @InjectMocks
    private WebController webController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testClassify() {
        webController.classify();

        verify(hotspotClassifier, times(1)).classify();
    }

    @Test
    void testGetOwasp1() {
        List<Hotspot> owasp1List = new ArrayList<>();
        owasp1List.add(new Hotspot());
        owasp1List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa1()).thenReturn(owasp1List);
        List<Hotspot> result = webController.getOwasp1();
        assertEquals(owasp1List, result);
    }

    @Test
    void testGetOwasp2() {
        List<Hotspot> owasp2List = new ArrayList<>();
        owasp2List.add(new Hotspot());
        owasp2List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa2()).thenReturn(owasp2List);

        List<Hotspot> result = webController.getOwasp2();

        assertEquals(owasp2List, result);
    }

    @Test
    void testGetOwasp3() {
        List<Hotspot> owasp3List = new ArrayList<>();
        owasp3List.add(new Hotspot());
        owasp3List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa3()).thenReturn(owasp3List);

        List<Hotspot> result = webController.getOwasp3();

        assertEquals(owasp3List, result);
    }

    @Test
    void testGetOwasp4() {
        List<Hotspot> owasp4List = new ArrayList<>();
        owasp4List.add(new Hotspot());
        owasp4List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa4()).thenReturn(owasp4List);

        List<Hotspot> result = webController.getOwasp4();

        assertEquals(owasp4List, result);
    }

    @Test
    void testGetOwasp5() {
        List<Hotspot> owasp5List = new ArrayList<>();
        owasp5List.add(new Hotspot());
        owasp5List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa5()).thenReturn(owasp5List);

        List<Hotspot> result = webController.getOwasp5();

        assertEquals(owasp5List, result);
    }

    @Test
    void testGetOwasp6() {
        List<Hotspot> owasp6List = new ArrayList<>();
        owasp6List.add(new Hotspot());
        owasp6List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa6()).thenReturn(owasp6List);

        List<Hotspot> result = webController.getOwasp6();

        assertEquals(owasp6List, result);
    }

    @Test
    void testGetOwasp7() {
        List<Hotspot> owasp7List = new ArrayList<>();
        owasp7List.add(new Hotspot());
        owasp7List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa7()).thenReturn(owasp7List);

        List<Hotspot> result = webController.getOwasp7();

        assertEquals(owasp7List, result);
    }

    @Test
    void testGetOwasp8() {
        List<Hotspot> owasp8List = new ArrayList<>();
        owasp8List.add(new Hotspot());
        owasp8List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa8()).thenReturn(owasp8List);

        List<Hotspot> result = webController.getOwasp8();

        assertEquals(owasp8List, result);
    }

    @Test
    void testGetOwasp9() {
        List<Hotspot> owasp9List = new ArrayList<>();
        owasp9List.add(new Hotspot());
        owasp9List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa9()).thenReturn(owasp9List);

        List<Hotspot> result = webController.getOwasp9();

        assertEquals(owasp9List, result);
    }

    @Test
    void testGetOwasp10() {
        List<Hotspot> owasp10List = new ArrayList<>();
        owasp10List.add(new Hotspot());
        owasp10List.add(new Hotspot());

        when(classifiedHotspots.getOwaspa10()).thenReturn(owasp10List);

        List<Hotspot> result = webController.getOwasp10();

        assertEquals(owasp10List, result);
    }




    @Test
    void testGetAll() {
        List<Hotspot> hotspotList = new ArrayList<>();
        hotspotList.add(new Hotspot());
        hotspotList.add(new Hotspot());

        when(hotspotResponse.getHotspots()).thenReturn(hotspotList);

        List<Hotspot> result = webController.getAll();

        assertEquals(hotspotList, result);
    }

    @Test
    void testGetRating() throws Exception {
        String expectedRating = "High";
        when(sonarQubeService.getSecurityReviewRating()).thenReturn(expectedRating);

        String result = webController.getRating();

        assertEquals(expectedRating, result);
    }

    @Test
    void testGetLastFive() {
        List<SecurityHistory> expectedList = new ArrayList<>();
        expectedList.add(new SecurityHistory());
        expectedList.add(new SecurityHistory());
        expectedList.add(new SecurityHistory());
        expectedList.add(new SecurityHistory());
        expectedList.add(new SecurityHistory());

        when(secuityHistoryJPA.findTop5ByOrderByDatetimeDesc()).thenReturn(expectedList);

        List<SecurityHistory> result = webController.getLastFive();

        assertEquals(expectedList, result);
    }
}

