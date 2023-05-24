package com.ericsson.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HotspotTest {

    @Test
    public void testHotspotToString() {
        // Create a Hotspot instance
        Hotspot hotspot = new Hotspot();
        hotspot.setKey("key");
        hotspot.setComponent("component");
        hotspot.setProject("project");
        hotspot.setSecurityCategory("securityCategory");
        hotspot.setVulnerabilityProbability("vulnerabilityProbability");
        hotspot.setStatus("status");
        hotspot.setLine(10);
        hotspot.setMessage("message");
        hotspot.setAuthor("author");
        hotspot.setCreationDate("creationDate");
        hotspot.setUpdateDate("updateDate");
        TextRange textRange = new TextRange();
        textRange.setStartLine(1);
        textRange.setEndLine(5);
        textRange.setStartOffset(0);
        textRange.setEndOffset(10);
        hotspot.setTextRange(textRange);
        List<Flow> flows = new ArrayList<>();
        Flow flow = new Flow();
        List<Location> locations = new ArrayList<>();
        Location location = new Location();
        location.setComponent("component");
        TextRange locationTextRange = new TextRange();
        locationTextRange.setStartLine(2);
        locationTextRange.setEndLine(3);
        locationTextRange.setStartOffset(1);
        locationTextRange.setEndOffset(5);
        location.setTextRange(locationTextRange);
        location.setMsg("msg");
        locations.add(location);
        flow.setLocations(locations);
        flows.add(flow);
        hotspot.setFlows(flows);
        hotspot.setRuleKey("ruleKey");

        // Verify the toString method
        String expectedToString = "Hotspot{" +
                "key='key'" +
                ", component='component'" +
                ", project='project'" +
                ", securityCategory='securityCategory'" +
                ", vulnerabilityProbability='vulnerabilityProbability'" +
                ", status='status'" +
                ", line=10" +
                ", message='message'" +
                ", author='author'" +
                ", creationDate='creationDate'" +
                ", updateDate='updateDate'" +
                ", textRange=" + textRange.toString() +
                ", flows=" + flows.toString() +
                ", ruleKey='ruleKey'" +
                '}';
        Assertions.assertEquals(expectedToString, hotspot.toString());

        // Verify the getter methods
        Assertions.assertEquals("key", hotspot.getKey());
        Assertions.assertEquals("component", hotspot.getComponent());
        Assertions.assertEquals("project", hotspot.getProject());
        Assertions.assertEquals("securityCategory", hotspot.getSecurityCategory());
        Assertions.assertEquals("vulnerabilityProbability", hotspot.getVulnerabilityProbability());
        Assertions.assertEquals("status", hotspot.getStatus());
        Assertions.assertEquals(10, hotspot.getLine());
        Assertions.assertEquals("message", hotspot.getMessage());
        Assertions.assertEquals("author", hotspot.getAuthor());
        Assertions.assertEquals("creationDate", hotspot.getCreationDate());
        Assertions.assertEquals("updateDate", hotspot.getUpdateDate());
        Assertions.assertEquals(textRange, hotspot.getTextRange());
        Assertions.assertEquals(flows, hotspot.getFlows());
        Assertions.assertEquals("ruleKey", hotspot.getRuleKey());
    }

    // Rest of the test methods for TextRange, Flow, and Location classes...
    @Test
    public void testTextRangeGetterMethods() {
        // Create a TextRange instance
        TextRange textRange = new TextRange();
        textRange.setStartLine(1);
        textRange.setEndLine(5);
        textRange.setStartOffset(0);
        textRange.setEndOffset(10);

        // Verify the getter methods
        Assertions.assertEquals(1, textRange.getStartLine());
        Assertions.assertEquals(5, textRange.getEndLine());
        Assertions.assertEquals(0, textRange.getStartOffset());
        Assertions.assertEquals(10, textRange.getEndOffset());
    }

    @Test
    public void testLocationGetterMethods() {
        // Create a Location instance
        Location location = new Location();
        location.setComponent("component");
        TextRange textRange = new TextRange();
        textRange.setStartLine(2);
        textRange.setEndLine(3);
        textRange.setStartOffset(1);
        textRange.setEndOffset(5);
        location.setTextRange(textRange);
        location.setMsg("msg");

        // Verify the getter methods
        Assertions.assertEquals("component", location.getComponent());
        Assertions.assertEquals(textRange, location.getTextRange());
        Assertions.assertEquals("msg", location.getMsg());
    }

    @Test
    public void testFlowGetLocations() {
        // Create a Flow instance
        Flow flow = new Flow();

        // Create a list of locations
        List<Location> locations = new ArrayList<>();

        // Create and add Location instances to the list
        Location location1 = new Location();
        location1.setComponent("component1");
        TextRange location1TextRange = new TextRange();
        location1TextRange.setStartLine(2);
        location1TextRange.setEndLine(3);
        location1TextRange.setStartOffset(1);
        location1TextRange.setEndOffset(5);
        location1.setTextRange(location1TextRange);
        location1.setMsg("msg1");
        locations.add(location1);

        Location location2 = new Location();
        location2.setComponent("component2");
        TextRange location2TextRange = new TextRange();
        location2TextRange.setStartLine(4);
        location2TextRange.setEndLine(6);
        location2TextRange.setStartOffset(2);
        location2TextRange.setEndOffset(6);
        location2.setTextRange(location2TextRange);
        location2.setMsg("msg2");
        locations.add(location2);

        // Set the locations in the Flow instance
        flow.setLocations(locations);

        // Verify the getLocations method
        Assertions.assertEquals(locations, flow.getLocations());
    }


}




//import com.ericsson.entity.Flow;
//import com.ericsson.entity.Hotspot;
//import com.ericsson.entity.Location;
//import com.ericsson.entity.TextRange;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class HotspotTest {
//
//    private Hotspot hotspot;
//
//    @BeforeEach
//    void setUp() {
//        hotspot = new Hotspot();
//    }
//
//    @Test
//    void testKey() {
//        String key = "hotspot_key";
//        hotspot.setKey(key);
//        String result = hotspot.getKey();
//        assertNotNull(result);
//        assertEquals(key, result);
//    }
//
//    @Test
//    void testComponent() {
//        String component = "hotspot_component";
//        hotspot.setComponent(component);
//        String result = hotspot.getComponent();
//        assertNotNull(result);
//        assertEquals(component, result);
//    }
//
//    @Test
//    void testProject() {
//        String project = "hotspot_project";
//        hotspot.setProject(project);
//        String result = hotspot.getProject();
//        assertNotNull(result);
//        assertEquals(project, result);
//    }
//
//    @Test
//    void testSecurityCategory() {
//        String securityCategory = "hotspot_security_category";
//        hotspot.setSecurityCategory(securityCategory);
//        String result = hotspot.getSecurityCategory();
//        assertNotNull(result);
//        assertEquals(securityCategory, result);
//    }
//
//    @Test
//    void testVulnerabilityProbability() {
//        String vulnerabilityProbability = "high";
//        hotspot.setVulnerabilityProbability(vulnerabilityProbability);
//        String result = hotspot.getVulnerabilityProbability();
//        assertNotNull(result);
//        assertEquals(vulnerabilityProbability, result);
//    }
//
//    @Test
//    void testStatus() {
//        String status = "open";
//        hotspot.setStatus(status);
//        String result = hotspot.getStatus();
//        assertNotNull(result);
//        assertEquals(status, result);
//    }
//
//    @Test
//    void testLine() {
//        int line = 10;
//        hotspot.setLine(line);
//        int result = hotspot.getLine();
//        assertEquals(line, result);
//    }
//
//    @Test
//    void testMessage() {
//        String message = "hotspot_message";
//        hotspot.setMessage(message);
//        String result = hotspot.getMessage();
//        assertNotNull(result);
//        assertEquals(message, result);
//    }
//
//    @Test
//    void testAuthor() {
//        String author = "John Doe";
//        hotspot.setAuthor(author);
//        String result = hotspot.getAuthor();
//        assertNotNull(result);
//        assertEquals(author, result);
//    }
//
//    @Test
//    void testCreationDate() {
//        String creationDate = "2023-05-24";
//        hotspot.setCreationDate(creationDate);
//        String result = hotspot.getCreationDate();
//        assertNotNull(result);
//        assertEquals(creationDate, result);
//    }
//
//    @Test
//    void testUpdateDate() {
//        String updateDate = "2023-05-25";
//        hotspot.setUpdateDate(updateDate);
//        String result = hotspot.getUpdateDate();
//        assertNotNull(result);
//        assertEquals(updateDate, result);
//    }
//
//    @Test
//    void testTextRange() {
//        TextRange textRange = new TextRange();
//        // Set values for textRange fields
//
//        hotspot.setTextRange(textRange);
//        TextRange result = hotspot.getTextRange();
//        assertNotNull(result);
//        assertEquals(textRange, result);
//    }
//
//    @Test
//    void testFlows() {
//        List<Flow> flows = new ArrayList<>();
//        // Add test flows to the list
//
//        hotspot.setFlows(flows);
//        List<Flow> result = hotspot.getFlows();
//        assertNotNull(result);
//        assertEquals(flows, result);
//    }
//
//    @Test
//    void testRuleKey() {
//        String ruleKey = "hotspot_rule_key";
//        hotspot.setRuleKey(ruleKey);
//        String result = hotspot.getRuleKey();
//        assertNotNull(result);
//        assertEquals(ruleKey, result);
//    }
//}

