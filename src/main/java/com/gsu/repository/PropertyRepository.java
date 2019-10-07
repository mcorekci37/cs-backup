package com.gsu.repository;

import com.gsu.model.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property,Long> {
}
