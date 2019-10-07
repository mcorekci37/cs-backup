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
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String mark;
    private String model;
    @ManyToOne
    private Announcement announcement;
    @ManyToOne
    private Client client;
    @OneToMany
    private List<Property> propertyList; //{pamuk,45, 2200}

    
    public Machine(String description, String mark, String model) {
        this.description = description;
        this.mark = mark;
        this.model = model;
        this.propertyList = new ArrayList<>();
    }
    public Machine() {
    }
    
    public boolean addProperty(String type,int minute,int voltage){
        try{
            Property p = new Property(type,minute,voltage);
            System.out.println("Adding property is OK1");
            
            this.getPropertyList().add(p);
            System.out.println("Adding property is OK2");
            return true;
        }
        catch (Exception e)
        {
            System.out.println("XXX "+e);
            return false;
        }
        
    }
    public boolean addProperty(Property p){
        try{
            this.propertyList.add(p);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }        
    }

    @Override
    public String toString() {
        String str=description + ", Özellikleri=";
        for (int i = 0; i<this.propertyList.size(); i++){
            str+=this.propertyList.get(i);
        }
        return str;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    
    
}
