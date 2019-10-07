package com.gsu.repository;

import com.gsu.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {
    public List<Client> findByName(String name);
    public List<Client> findByMail(String mail);

}
