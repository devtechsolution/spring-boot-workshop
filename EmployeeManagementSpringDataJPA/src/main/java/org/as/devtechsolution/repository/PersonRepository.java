package org.as.devtechsolution.repository;

import java.util.List;

import org.as.devtechsolution.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	List<Person> findByLastName(String lastName);
	List<Person> findByFirstNameAndEmail(String firstName,String email);

}
