/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.model;

import java.io.Serializable;
import javax.crypto.Mac;
import javax.persistence.*;

/**
 *
 * @author Atadam
 */
@Entity
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private int minutee;
    private int voltage;
    @ManyToOne
    private Machine machine;

    public Property(String type, int minutee, int voltage) {
        this.type = type;
        this.minutee = minutee;
        this.voltage = voltage;
    }
    public Property() {    }

    @Override
    public String toString() {
        return type + "(" + minutee + "dk),";
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getMinute() {
        return minutee;
    }

    public void setMinute(int minute) {
        this.minutee = minute;
    }

    
}
