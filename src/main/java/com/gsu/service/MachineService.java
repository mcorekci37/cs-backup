/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.service;


import com.gsu.model.Machine;
import com.gsu.model.Property;
import com.gsu.repository.MachineRepository;
import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages_zh_CN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atadam
 */
@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private PropertyService propertyService;
    public void create(Machine m){
        machineRepository.save(m);
    }
    public boolean addPropertyToMachine(Long machineId, Property property){
        try {
            propertyService.create(property);
            Machine machine= machineRepository.findById(machineId).get();
            machine.getPropertyList().add(property);
            machineRepository.save(machine);
            return true;
        }catch (Exception e){
            System.out.println("Error in addPropertyToMachine: "+ e);
            return false;
        }
    }

}
