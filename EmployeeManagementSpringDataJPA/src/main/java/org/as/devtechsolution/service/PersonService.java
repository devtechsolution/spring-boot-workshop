package org.as.devtechsolution.service;

import java.util.List;

import org.as.devtechsolution.entity.Person;

public interface PersonService {
	public Person createPerson(Person person);

	public Iterable<Person> createPersons(List<Person> personList);

	public Iterable<Person> getPersonByIds(List<Integer> ids);

	public void deletePersonEntity(Person person);

	public void updatePersonEmailById(int id, String newEmail) ;
	
	List<Person> findByLastName(String lastName);
	
	List<Person> findByFirstNameAndEmail(String firstName,String email);
}
