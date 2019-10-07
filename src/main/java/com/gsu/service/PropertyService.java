package com.gsu.service;

import com.gsu.model.Property;
import com.gsu.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;
    public void create(Property property){
        propertyRepository.save(property);
    }

}
