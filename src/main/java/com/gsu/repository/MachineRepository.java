package com.gsu.repository;

import com.gsu.model.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository<Machine,Long> {
}
