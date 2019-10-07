package com.gsu.controller;

import com.gsu.model.Property;
import com.gsu.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MachineController {

    @Autowired
    private MachineService machineService;

    @PostMapping("/machines/{machineId}")
    public void addPropertyToMachine(@PathVariable("machineId") Long machineId, @RequestBody Property property){
        machineService.addPropertyToMachine(machineId, property);
    }}
