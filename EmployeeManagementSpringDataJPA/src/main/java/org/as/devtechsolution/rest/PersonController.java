package org.as.devtechsolution.rest;

import java.util.ArrayList;
import java.util.List;

import org.as.devtechsolution.entity.Person;
import org.as.devtechsolution.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping(value="/person")
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		
		return new ResponseEntity<Person>(personService.createPerson(person), HttpStatus.CREATED);
	}
	
	@PostMapping(value="/persons")
	public ResponseEntity<List<Person>> getPersonById(@RequestBody List<Person> persons){
		List<Person> personList = (List<Person>) personService.createPersons(persons);
		return new ResponseEntity<List<Person>>(personList,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/persons/{ids}")
	public ResponseEntity<List<Person>> getPersonsByIds(@PathVariable List<Integer> ids){
		
		/*
		 * List<Integer> ids=new ArrayList<>(); strids.forEach(id->{
		 * ids.add(Integer.valueOf(id)); });
		 */
		
		Iterable<Person> personByIds = personService.getPersonByIds(ids);
		
		
		return new ResponseEntity<List<Person>>((List<Person>) personByIds, HttpStatus.OK) ;
	}
	
	@DeleteMapping(value="persons")
	public ResponseEntity<Void> deletePerson(@RequestBody Person person) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value="/persons/{id}/{email:.+}")
	public ResponseEntity<Void>  updatePersonEmailById(@PathVariable("id") Integer id, 
			@PathVariable("email") String  email) {
		personService.updatePersonEmailById(id, email);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	

}
