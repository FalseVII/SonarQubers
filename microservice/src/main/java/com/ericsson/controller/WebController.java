package com.ericsson.controller;

import com.ericsson.entity.Hotspot;
import com.ericsson.entity.Hotspot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    private com.ericsson.service.SonarQubeService sonarQubeService;

    @Autowired
    private com.ericsson.entity.HotspotResponse hotspotResponse;

    @Autowired
    private com.ericsson.entity.Hotspot Hotspot;

    @Autowired
    private com.ericsson.service.HotspotClassifier HotspotClassifier;

    @Autowired
    private com.ericsson.entity.ClassifiedHotspots classifiedHotspots;



    @PostMapping(value = "/classify")
    public void classify() {
        HotspotClassifier.classify();
    }

    @GetMapping(value = "/api/v1/owasp1")
    public List<Hotspot> getOwasp1() {
        return classifiedHotspots.getOwaspa1();
    }

    @GetMapping(value = "/api/v1/owasp2")
    public List<Hotspot> getOwasp2() {
        return classifiedHotspots.getOwaspa2();
    }

    @GetMapping(value = "/api/v1/owasp3")
    public List<Hotspot> getOwasp3() {
        return classifiedHotspots.getOwaspa3();
    }

    @GetMapping(value = "/api/v1/owasp4")
    public List<Hotspot> getOwasp4() {
        return classifiedHotspots.getOwaspa4();
    }

    @GetMapping(value = "/api/v1/owasp5")
    public List<Hotspot> getOwasp5() {
        return classifiedHotspots.getOwaspa5();
    }

    @GetMapping(value = "/api/v1/owasp6")
    public List<Hotspot> getOwasp6() {
        return classifiedHotspots.getOwaspa6();
    }

    @GetMapping(value = "/api/v1/owasp7")
    public List<Hotspot> getOwasp7() {
        return classifiedHotspots.getOwaspa7();
    }

    @GetMapping(value = "/api/v1/owasp8")
    public List<Hotspot> getOwasp8() {
        return classifiedHotspots.getOwaspa8();
    }

    @GetMapping(value = "/api/v1/owasp9")
    public List<Hotspot> getOwasp9() {
        return classifiedHotspots.getOwaspa9();
    }

    @GetMapping(value = "/api/v1/owasp10")
    public List<Hotspot> getOwasp10() {
        return classifiedHotspots.getOwaspa10();
    }

    @GetMapping(value = "/api/v1/cest")
    public List<Hotspot> getCest() {
        return classifiedHotspots.getCest();
    }

    @GetMapping(value = "/api/v1/cwe")
    public List<Hotspot> getCwe() {
        return classifiedHotspots.getCwe();
    }

    @GetMapping(value = "/api/v1/all")
    public List<Hotspot> getAll() {
        return hotspotResponse.getHotspots();
    }

    @GetMapping(value = "/api/v1/rating")
    public String getRating() throws Exception {
        return sonarQubeService.getSecurityReviewRating();
    }
}
