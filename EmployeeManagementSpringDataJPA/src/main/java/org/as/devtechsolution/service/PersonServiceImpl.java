package org.as.devtechsolution.service;

import java.util.List;
import java.util.Optional;

import org.as.devtechsolution.entity.Person;
import org.as.devtechsolution.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Iterable<Person> createPersons(List<Person> personList) {
		
		return personRepo.saveAll(personList);
	}

	@Override
	public Iterable<Person> getPersonByIds(List<Integer> ids) {
		return personRepo.findAllById(ids);
	}

	@Override
	public void deletePersonEntity(Person person) {
		personRepo.delete(person);
	}

	@Override
	public void updatePersonEmailById(int id, String newEmail) {
		Optional<Person> person = personRepo.findById(id);
		Person p= null;
		if (person.isPresent()) {
			p=person.get();
			p.setEmail(newEmail);
			personRepo.save(p);
		}
		

	}

	@Override
	public List<Person> findByLastName(String lastName) {
		//return personRepo.findByLastName(lastName);
		return personRepo.getByLastName(lastName);
	}

	@Override
	public List<Person> findByFirstNameAndEmail(String firstName, String email) {
		//return personRepo.findByFirstNameAndEmail(firstName, email);
		return personRepo.getByFirstNameAndEmail(firstName, email);
	}

}
