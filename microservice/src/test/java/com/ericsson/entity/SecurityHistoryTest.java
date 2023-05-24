package com.ericsson.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class SecurityHistoryTest {

    @Test
    public void testSecurityHistoryGettersAndSetters() {
        // Create a SecurityHistory instance
        SecurityHistory securityHistory = new SecurityHistory();
        securityHistory.setId(1L);
        securityHistory.setProj_name("project");
        LocalDateTime datetime = LocalDateTime.now();
        securityHistory.setDatetime(datetime);
        securityHistory.setOwasp1_count("10");
        securityHistory.setOwasp2_count("5");
        securityHistory.setOwasp3_count("3");
        securityHistory.setOwasp4_count("8");
        securityHistory.setOwasp5_count("2");
        securityHistory.setOwasp6_count("7");
        securityHistory.setOwasp7_count("9");
        securityHistory.setOwasp8_count("1");
        securityHistory.setOwasp9_count("4");
        securityHistory.setOwasp10_count("6");
        securityHistory.setCest_count("12");
        securityHistory.setCwe_count("15");

        // Verify the getter methods
        Assertions.assertEquals(1L, securityHistory.getId());
        Assertions.assertEquals("project", securityHistory.getProj_name());
        Assertions.assertEquals(datetime, securityHistory.getDatetime());
        Assertions.assertEquals("10", securityHistory.getOwasp1_count());
        Assertions.assertEquals("5", securityHistory.getOwasp2_count());
        Assertions.assertEquals("3", securityHistory.getOwasp3_count());
        Assertions.assertEquals("8", securityHistory.getOwasp4_count());
        Assertions.assertEquals("2", securityHistory.getOwasp5_count());
        Assertions.assertEquals("7", securityHistory.getOwasp6_count());
        Assertions.assertEquals("9", securityHistory.getOwasp7_count());
        Assertions.assertEquals("1", securityHistory.getOwasp8_count());
        Assertions.assertEquals("4", securityHistory.getOwasp9_count());
        Assertions.assertEquals("6", securityHistory.getOwasp10_count());
        Assertions.assertEquals("12", securityHistory.getCest_count());
        Assertions.assertEquals("15", securityHistory.getCwe_count());
    }
}
