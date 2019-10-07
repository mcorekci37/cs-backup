/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.service;

import com.gsu.model.*;
import com.gsu.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atadam
 */
@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;
    public void create(Announcement a){
        announcementRepository.save(a);
    }
    public Announcement findById(Long id){
        return announcementRepository.findById(id).get();
    }
    public void update(Announcement a){
        announcementRepository.save(a);
    }

}
