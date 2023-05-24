package com.ericsson.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HotspotResponseTest {

    @Test
    public void testHotspotResponseGetHotspots() {
        // Create a list of hotspots
        List<Hotspot> hotspots = new ArrayList<>();

        // Create Hotspot instances and add them to the list
        Hotspot hotspot1 = new Hotspot();
        hotspot1.setKey("key1");
        hotspots.add(hotspot1);

        Hotspot hotspot2 = new Hotspot();
        hotspot2.setKey("key2");
        hotspots.add(hotspot2);

        // Create a HotspotResponse instance
        HotspotResponse hotspotResponse = new HotspotResponse();
        hotspotResponse.setHotspots(hotspots);

        // Verify the getHotspots method
        Assertions.assertEquals(hotspots, hotspotResponse.getHotspots());
    }
}

