/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Atadam
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    private String address;
    private String telNumber;
    private String mail;
    private String password; 
    private int mandal=50;
    @OneToMany
    private List<Machine> machineList;
    @OneToMany
    private List<Announcement> announcementList;
    @OneToMany
    private List<Task> taskList;

    public Client (String name, String surname, Date birthday, String address, String telNumber, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.telNumber = telNumber;
        this.mail = mail;
        this.password = password;
        this.machineList = new ArrayList<>();
        this.announcementList = new ArrayList<>();
        this.taskList = new ArrayList<>();
        this.mandal=50;
    }
    public Client(){       }
    public Client(String name){   this.name=name;    }



    @Override
    public String toString() {
        return name+" "+surname;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }
    
    

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    
    
    public int getMandal() {
        return mandal;
    }

    public void addMandal(int mandal) {
        this.mandal += mandal;
    }

    public void removeMandal(int mandal) {
        this.mandal -= mandal;
    }
    
    
    
}
