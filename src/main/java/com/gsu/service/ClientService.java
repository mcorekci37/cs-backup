/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.service;

import com.gsu.model.*;
import com.gsu.repository.ClientRepository;
import com.gsu.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Atadam
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    MachineService machineService;

    public void create(Client c){
        clientRepository.save(c);
    }
    public Client findById(Long id){
        return clientRepository.findById(id).get();
    }
    public Client findByName(String name){
        return clientRepository.findByName(name).get(0);
    }
    public Client findByMail(String mail){
        Client c;
        try {
            c=clientRepository.findByMail(mail).get(0);
        }catch (Exception e){
            c=null;
        }
        return c;
    }
    public void update(Client cl){
        clientRepository.save(cl);
    }
    public void merge(Client cl){
    }
    public void initClients(){
        SimpleDateFormat sf= new SimpleDateFormat ("dd/MM/YYYY");
        Client client = new Client("Mustafa","COREKCI",new Date(),"Bagcilar","5347909837","mustafa@corekci","123");
        clientRepository.save(client);
        client = new Client("Harun","DAG",new Date(),"Ortakoy","534790211","b@b ","2");
        clientRepository.save(client);

        LoundryMachine lmachine=new LoundryMachine("camasirMakinem","arcelik","2015 model",5);
        machineService.create(lmachine);
        Property property = new Property("pamuk",45,1200);
        machineService.addPropertyToMachine(lmachine.getId(), property);
        property = new Property("on_yikama",20,1000);
        machineService.addPropertyToMachine(lmachine.getId(),property);
        addMachineToClient(client.getId(),lmachine);

        DryingMachine dmachine=new DryingMachine("kurutmaMakinem","arcelik","2014 model",5);
        machineService.create(dmachine);
        property = new Property("genel",35,1700);
        machineService.addPropertyToMachine(dmachine.getId(),property);
        addMachineToClient(client.getId(),dmachine);

        IroningMachine imachine=new IroningMachine("utuMakinem","beko","2018 model");
        machineService.create(imachine);
        property = new Property("pamuk",10,400);
        machineService.addPropertyToMachine(imachine.getId(),property);
        addMachineToClient(client.getId(),imachine);


/*
        Announcement a = new Announcement(client.getId(),"Üsküdarda ucuza yikama",
                " 50 mandal değerine arçelik çamaşır+yıkama(her özellik mevcuttur.)",DEFAULT_COST) ;
        Machine mtemp=userService.getMachineByDescription(client.getId(),"camasirMakinem");
        a.addMachine(mtemp);

        userService.publishAnnouncement(a);

        Task t = userService.startTask(a,client2.getId());
        userService.endTask(t.getId(), new Date());
*/
    }
    public boolean addMachineToClient(Long clientId, Machine m){
        try {
            machineService.create(m);
            Client client=clientRepository.findById(clientId).get();
            client.getMachineList().add(m);
            clientRepository.save(client);
            return true;
        }catch (Exception e){
            System.out.println("Error in addMachineToClient: "+ e);
            return false;
        }
    }
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
    public List<Client> findAll(){
        List<Client> clients=new ArrayList<>();
        clientRepository.findAll()
                .forEach(clients::add);
        return clients;
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }
}
