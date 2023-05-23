package com.ericsson.entity;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassifiedHotspots {

    List<Hotspot> owaspa1;
    List<Hotspot> owaspa2;
    List<Hotspot> owaspa3;
    List<Hotspot> owaspa4;
    List<Hotspot> owaspa5;
    List<Hotspot> owaspa6;
    List<Hotspot> owaspa7;
    List<Hotspot> owaspa8;
    List<Hotspot> owaspa9;
    List<Hotspot> owaspa10;
    List<Hotspot> cest;
    List<Hotspot> cwe;

    public List<Hotspot> getOwaspa1() {
        return owaspa1;
    }

    public void setOwaspa1(List<Hotspot> owaspa1) {
        this.owaspa1 = owaspa1;
    }

    public List<Hotspot> getOwaspa2() {
        return owaspa2;
    }

    public void setOwaspa2(List<Hotspot> owaspa2) {
        this.owaspa2 = owaspa2;
    }

    public List<Hotspot> getOwaspa3() {
        return owaspa3;
    }

    public void setOwaspa3(List<Hotspot> owaspa3) {
        this.owaspa3 = owaspa3;
    }

    public List<Hotspot> getOwaspa4() {
        return owaspa4;
    }

    public void setOwaspa4(List<Hotspot> owaspa4) {
        this.owaspa4 = owaspa4;
    }

    public List<Hotspot> getOwaspa5() {
        return owaspa5;
    }

    public void setOwaspa5(List<Hotspot> owaspa5) {
        this.owaspa5 = owaspa5;
    }

    public List<Hotspot> getOwaspa6() {
        return owaspa6;
    }

    public void setOwaspa6(List<Hotspot> owaspa6) {
        this.owaspa6 = owaspa6;
    }

    public List<Hotspot> getOwaspa7() {
        return owaspa7;
    }

    public void setOwaspa7(List<Hotspot> owaspa7) {
        this.owaspa7 = owaspa7;
    }

    public List<Hotspot> getOwaspa8() {
        return owaspa8;
    }

    public void setOwaspa8(List<Hotspot> owaspa8) {
        this.owaspa8 = owaspa8;
    }

    public List<Hotspot> getOwaspa9() {
        return owaspa9;
    }

    public void setOwaspa9(List<Hotspot> owaspa9) {
        this.owaspa9 = owaspa9;
    }

    public List<Hotspot> getOwaspa10() {
        return owaspa10;
    }

    public void setOwaspa10(List<Hotspot> owaspa10) {
        this.owaspa10 = owaspa10;
    }

    public List<Hotspot> getCest() {
        return cest;
    }

    public void setCest(List<Hotspot> cest) {
        this.cest = cest;
    }

    public List<Hotspot> getCwe() {
        return cwe;
    }

    public void setCwe(List<Hotspot> cwe) {
        this.cwe = cwe;
    }
}
