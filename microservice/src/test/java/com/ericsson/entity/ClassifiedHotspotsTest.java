package com.ericsson.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClassifiedHotspotsTest {

    private ClassifiedHotspots classifiedHotspots;

    @BeforeEach
    void setUp() {
        classifiedHotspots = new ClassifiedHotspots();
    }

    @Test
    void testOwaspa1() {
        List<Hotspot> owaspa1 = new ArrayList<>();
        // Add test data to owaspa1

        classifiedHotspots.setOwaspa1(owaspa1);

        List<Hotspot> result = classifiedHotspots.getOwaspa1();

        assertNotNull(result);
        assertEquals(owaspa1, result);
    }

    // Repeat the same pattern for the other getters/setters

    @Test
    void testCest() {
        List<Hotspot> cest = new ArrayList<>();
        // Add test data to cest

        classifiedHotspots.setCest(cest);

        List<Hotspot> result = classifiedHotspots.getCest();

        assertNotNull(result);
        assertEquals(cest, result);
    }

    @Test
    void testCwe() {
        List<Hotspot> cwe = new ArrayList<>();
        // Add test data to cwe

        classifiedHotspots.setCwe(cwe);

        List<Hotspot> result = classifiedHotspots.getCwe();

        assertNotNull(result);
        assertEquals(cwe, result);
    }

    @Test
    void testOwaspa2() {
        List<Hotspot> owaspa2 = new ArrayList<>();
        // Add test data to owaspa2

        classifiedHotspots.setOwaspa2(owaspa2);

        List<Hotspot> result = classifiedHotspots.getOwaspa2();

        assertNotNull(result);
        assertEquals(owaspa2, result);
    }

    @Test
    void testOwaspa3() {
        List<Hotspot> owaspa3 = new ArrayList<>();
        // Add test data to owaspa3

        classifiedHotspots.setOwaspa3(owaspa3);

        List<Hotspot> result = classifiedHotspots.getOwaspa3();

        assertNotNull(result);
        assertEquals(owaspa3, result);
    }

    @Test
    void testOwaspa4() {
        List<Hotspot> owaspa4 = new ArrayList<>();
        // Add test data to owaspa4

        classifiedHotspots.setOwaspa4(owaspa4);

        List<Hotspot> result = classifiedHotspots.getOwaspa4();

        assertNotNull(result);
        assertEquals(owaspa4, result);
    }

    // Repeat the same pattern for the remaining getter/setter methods (owaspa5 to owaspa10)

    @Test
    void testOwaspa5() {
        List<Hotspot> owaspa5 = new ArrayList<>();
        // Add test data to owaspa5

        classifiedHotspots.setOwaspa5(owaspa5);

        List<Hotspot> result = classifiedHotspots.getOwaspa5();

        assertNotNull(result);
        assertEquals(owaspa5, result);
    }

    // Repeat the same pattern for the remaining getter/setter methods (owaspa6 to owaspa10)

    @Test
    void testOwaspa6() {
        List<Hotspot> owaspa6 = new ArrayList<>();
        // Add test data to owaspa6

        classifiedHotspots.setOwaspa6(owaspa6);

        List<Hotspot> result = classifiedHotspots.getOwaspa6();

        assertNotNull(result);
        assertEquals(owaspa6, result);
    }

    // Repeat the same pattern for the remaining getter/setter methods (owaspa7 to owaspa10)

    @Test
    void testOwaspa7() {
        List<Hotspot> owaspa7 = new ArrayList<>();
        // Add test data to owaspa7

        classifiedHotspots.setOwaspa7(owaspa7);

        List<Hotspot> result = classifiedHotspots.getOwaspa7();

        assertNotNull(result);
        assertEquals(owaspa7, result);
    }

    // Repeat the same pattern for the remaining getter/setter methods (owaspa8 to owaspa10)

    @Test
    void testOwaspa8() {
        List<Hotspot> owaspa8 = new ArrayList<>();
        // Add test data to owaspa8

        classifiedHotspots.setOwaspa8(owaspa8);

        List<Hotspot> result = classifiedHotspots.getOwaspa8();

        assertNotNull(result);
        assertEquals(owaspa8, result);
    }

    // Repeat the same pattern for the remaining getter/setter methods (owaspa9 to owaspa10)

    @Test
    void testOwaspa9() {
        List<Hotspot> owaspa9 = new ArrayList<>();
        // Add test data to owaspa9

        classifiedHotspots.setOwaspa9(owaspa9);

        List<Hotspot> result = classifiedHotspots.getOwaspa9();

        assertNotNull(result);
        assertEquals(owaspa9, result);
    }

    // Repeat the same pattern for the remaining getter/setter methods (owaspa10)

    @Test
    void testOwaspa10() {
        List<Hotspot> owaspa10 = new ArrayList<>();
        // Add test data to owaspa10

        classifiedHotspots.setOwaspa10(owaspa10);

        List<Hotspot> result = classifiedHotspots.getOwaspa10();

        assertNotNull(result);
        assertEquals(owaspa10, result);
    }
}

