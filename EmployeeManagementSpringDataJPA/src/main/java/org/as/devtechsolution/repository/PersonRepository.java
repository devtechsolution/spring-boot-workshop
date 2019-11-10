package org.as.devtechsolution.repository;

import org.as.devtechsolution.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
