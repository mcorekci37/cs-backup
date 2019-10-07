package com.gsu.controller;

import com.gsu.model.Client;
import com.gsu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClientController {

    private final static String vueAppLink2="http://localhost:63343";
    private final static String vueAppLink="http://localhost:8080/";
    @Autowired
    private ClientService clientService;

    @PostMapping("/clients/{isim}")
    public void createClient(@PathVariable("isim") String isim){
        clientService.create(new Client(isim));
    }

    //post request for connection
    @PostMapping("/clients/{mail}/{password}")
    public Client connectionClient(@PathVariable("mail") String mail,@PathVariable("password") String password){
        Client c = clientService.findByMail(mail);
        if (c!=null){
            return ( c.getPassword() ).equals(password) ? c : null;
        }
        else return null;
//        Client client = new Client("Mustafa","COREKCI",new Date(),"Bagcilar","5347909837","a","1");
//        return client;
    }

    //post request for connection
    @PostMapping("/clients/signin")
    public Client signInClient(@PathVariable("mail") String mail,@PathVariable("password") String password){
        Client c = clientService.findByMail(mail);
        if (c!=null){
            return ( c.getPassword() ).equals(password) ? c : null;
        }
        else return null;
//        Client client = new Client("Mustafa","COREKCI",new Date(),"Bagcilar","5347909837","a","1");
//        return client;
    }

    //post request for inscription
    @PostMapping("/clients")
    public void createClient(@RequestBody Client client){
//    public void createClient(){
        clientService.create(client);
/*        clientService.create(new Client(
                client.getName(),client.getSurname(),client.getBirhtday(),client.getAddress(),
                client.getTelNumber(),client.getMail(),client.getPassword()
        ));*/
    }

    @GetMapping("/clients")
    public List<Client> getClient(){
        return clientService.findAll();
    }

    @GetMapping("/clients/init")
    public List<Client> initClients(){
        clientService.deleteAll();
        clientService.initClients();
        return clientService.findAll();
    }

    @PutMapping("/clients/{id}")
    public void updateClient(@RequestBody Client client){
        System.out.println("DELETE REQEST CAME");
        clientService.update(client);
    }

    @GetMapping("/clients/{isim}")
    public Client getClient(@PathVariable("isim") String isim){
        return clientService.findByName(isim);
    }

    @DeleteMapping("/clients/{id}")
    public void getClient(@PathVariable("id") Long id){
        System.out.println("DELETE REQEST CAME");
        clientService.deleteById(id);
    }
}
