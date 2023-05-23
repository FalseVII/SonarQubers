package com.ericsson.service;


import com.ericsson.entity.Hotspot;
import com.ericsson.entity.SecurityHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotspotClassifier {

    private com.ericsson.entity.HotspotResponse hotspotResponse;


    @Autowired
    private com.ericsson.entity.Hotspot hotspot;

    @Autowired
    private com.ericsson.service.SonarQubeService sonarQubeService;

    @Autowired
    private com.ericsson.entity.ClassifiedHotspots classifiedhotspots;

    @Autowired
    private com.ericsson.repository.SecuityHistoryJPA secuityHistoryJPA;


    private com.ericsson.entity.SecurityHistory securityHistory;

    public com.ericsson.entity.SecurityHistory getSecurityHistory() {
        return securityHistory;
    }

    public void classify() {
        List<Hotspot> owaspa1 = new ArrayList<>();
        List<Hotspot> owaspa2 = new ArrayList<>();
        List<Hotspot> owaspa3 = new ArrayList<>();
        List<Hotspot> owaspa4 = new ArrayList<>();
        List<Hotspot> owaspa5 = new ArrayList<>();
        List<Hotspot> owaspa6 = new ArrayList<>();
        List<Hotspot> owaspa7 = new ArrayList<>();
        List<Hotspot> owaspa8 = new ArrayList<>();
        List<Hotspot> owaspa9 = new ArrayList<>();
        List<Hotspot> owaspa10 = new ArrayList<>();
        List<Hotspot> cest = new ArrayList<>();
        List<Hotspot> cwe = new ArrayList<>();
        for (Hotspot hotspot : sonarQubeService.getIssues()) {
            System.out.println(hotspot.getRuleKey());
            if ( hotspot.getRuleKey().equals("java:S5852") || hotspot.getRuleKey().equals("java:S5443")) {
                owaspa1.add(hotspot);
            }
            if (hotspot.getRuleKey().equals("java:S4790") || hotspot.getRuleKey().equals("java:S6291") || hotspot.getRuleKey().equals("java:S2245") || hotspot.getRuleKey().equals("java:S2257") || hotspot.getRuleKey().equals("java:S5332")) {
                owaspa2.add(hotspot);
            }
            if (hotspot.getRuleKey().equals("java:S2077") || hotspot.getRuleKey().equals("java:S1313")|| hotspot.getRuleKey().equals("java:S4512")) {
                owaspa3.add(hotspot);
            }
            if (hotspot.getRuleKey().equals("java:S6300") || hotspot.getRuleKey().contains("java:S2612")) {
                owaspa4.add(hotspot);
            }
            if (hotspot.getRuleKey().equals("java:S5122")) {
                owaspa5.add(hotspot);
            }
            if (hotspot.getRuleKey().equals("java:S6362") || hotspot.getRuleKey().equals("java:S5042")) {
                owaspa6.add(hotspot);
            }
            if (hotspot.getRuleKey().contains("java:S2068") || hotspot.getRuleKey().equals("java:S6293") || hotspot.getRuleKey().equals("java:S6418")) {
                owaspa7.add(hotspot);
            }
            if (hotspot.getRuleKey().equals("java:S4544") || hotspot.getRuleKey().equals("java:S4036")) {
                owaspa8.add(hotspot);
            }

        }
        classifiedhotspots.setOwaspa1(owaspa1);
        classifiedhotspots.setOwaspa2(owaspa2);
        classifiedhotspots.setOwaspa3(owaspa3);
        classifiedhotspots.setOwaspa4(owaspa4);
        classifiedhotspots.setOwaspa5(owaspa5);
        classifiedhotspots.setOwaspa6(owaspa6);
        classifiedhotspots.setOwaspa7(owaspa7);
        classifiedhotspots.setOwaspa8(owaspa8);
        classifiedhotspots.setOwaspa9(owaspa9);
        classifiedhotspots.setOwaspa10(owaspa10);



        securityHistory = new SecurityHistory();
        securityHistory.setDatetime(LocalDateTime.parse(LocalDateTime.now().toString()));
        securityHistory.setProj_name("Test");
        securityHistory.setOwasp1_count(String.valueOf(owaspa1.size()));
        securityHistory.setOwasp2_count(String.valueOf(owaspa2.size()));
        securityHistory.setOwasp3_count(String.valueOf(owaspa3.size()));
        securityHistory.setOwasp4_count(String.valueOf(owaspa4.size()));
        securityHistory.setOwasp5_count(String.valueOf(owaspa5.size()));
        securityHistory.setOwasp6_count(String.valueOf(owaspa6.size()));
        securityHistory.setOwasp7_count(String.valueOf(owaspa7.size()));
        securityHistory.setOwasp8_count(String.valueOf(owaspa8.size()));
        securityHistory.setOwasp9_count(String.valueOf(owaspa9.size()));
        securityHistory.setOwasp10_count(String.valueOf(owaspa10.size()));
        securityHistory.setCest_count(String.valueOf(cest.size()));
        securityHistory.setCwe_count(String.valueOf(cwe.size()));
        secuityHistoryJPA.save(securityHistory);



        System.out.println("Classified hotspots");
    }
}
