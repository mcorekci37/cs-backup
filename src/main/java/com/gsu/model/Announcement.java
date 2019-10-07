/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Atadam
 */
@Entity
public class Announcement implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    private String description;
    private int price;
    private String location;//NEEDS TO BE GPS BUT HOW?
    private String address;
//    private Long clientId;
    @OneToMany
    private List<Machine> machineList;
    @ManyToOne
    private Client client;
    private boolean visibility;
    
    public Announcement(Long clientId,String header, String description, int price) {
//        this.clientId=clientId;
        this.header = header;
        this.description = description;
        this.price = price;

        this.visibility = true;
        this.machineList = new ArrayList<>();

    }

    public Announcement() {}


    @Override
    public String toString() {
        return "header=" + header;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }


    public List<Machine> getMachineIDList() {
        return machineList;
    }

    public void setMachineIDList(List<Machine> machineIDList) {
        this.machineList = machineIDList;
    }

}
