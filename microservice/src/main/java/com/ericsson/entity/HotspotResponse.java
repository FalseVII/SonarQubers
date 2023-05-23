package com.ericsson.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotspotResponse {
    private List<Hotspot> hotspots;

    public List<Hotspot> getHotspots() {
        return hotspots;
    }

    public void setHotspots(List<Hotspot> hotspots) {
        this.hotspots = hotspots;
    }
}